package org.ocmc.ioc.liturgical.schemas.models.readings;

	import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.BIBLICAL_BOOKS_ENUM;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

	
	/**
	 * Provides a model for meta-data about Scripture readings
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Pericope", description = "Indicates which Biblical texts to read.")
	public class Pericope extends LTKDb {
		private static final Logger logger = LoggerFactory.getLogger(Pericope.class);
		private static String schema = Pericope.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(id="top", required = true, description = "Book code")
		@Expose  public BIBLICAL_BOOKS_ENUM book = null;
	
		@Attributes(id="top", required = true, description = "ID of text used to introduce the reading.")
		@Expose  public String leadinId = "";
	
		@Attributes(id="top", required = true, description = "The citation form of the book, chapter, verse for the reading")
		@Expose  public String citation = "";

		@Attributes(id="top", required = true, description = "The readings")
		@Expose  public List<PericopeBlock> blocks = new ArrayList<PericopeBlock>();
	
		@Attributes(id="top", required = true, description = "Where the readings are used.")
		@Expose  public List<String> whereUsed = new ArrayList<String>();
		
		public Pericope(
				BIBLICAL_BOOKS_ENUM book
				, String key
				)  {
			super(
					Constants.LIBRARY_READINGS
					, Constants.TOPIC_PERICOPE
					, key
					, schema
					, version
					, TOPICS.PERICOPE
					);
			this.book = book;
			this.setPrettyPrint(false);
		}
		
		public void addBlock(PericopeBlock block) {
			this.blocks.add(block);
		}

		public List<PericopeBlock> getBlocks() {
			return blocks;
		}

		public void setBlocks(List<PericopeBlock> blocks) {
			this.blocks = blocks;
		}

		public String getLeadinId() {
			return leadinId;
		}

		public void setLeadinId(String leadinId) {
			this.leadinId = leadinId;
		}

		public BIBLICAL_BOOKS_ENUM getBook() {
			return book;
		}

		public void setBook(BIBLICAL_BOOKS_ENUM book) {
			this.book = book;
		}

		public List<String> getWhereUsed() {
			return whereUsed;
		}

		public void setWhereUsed(List<String> whereUsed) {
			this.whereUsed = whereUsed;
		}

		public String getCitation() {
			return citation;
		}

		public void setCitation(String citation) {
			this.citation = citation;
		}
		
		public void createCitation() {
			StringBuffer sb = new StringBuffer();
			String lastBook = "";
			String lastChapter = "";
			for (PericopeBlock b : this.blocks) {
				if (sb.length() > 0) {
					sb.append(";");
				}
				if (! lastBook.equals(b.book.name())) {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					lastBook = b.book.name();
					sb.append(lastBook);
				}
//				if (! lastChapter.equals(b.chapter)) {
					sb.append(" ");
					lastChapter = b.chapter;
					try { 
						sb.append(Integer.parseInt(lastChapter.substring(1)));
					} catch (Exception e) {
						sb.append(lastChapter);
					}
	//			}
				sb.append(".");
				try {
					sb.append(Integer.parseInt(b.verseFrom));
				} catch (Exception e) {
					sb.append(b.verseFrom);
				}
				if (! b.verseTo.equals(b.verseFrom)) {
					sb.append("-");
					try {
						sb.append(Integer.parseInt(b.verseTo));
					} catch (Exception e) {
						sb.append(b.verseTo);
					}
				}
			}
			this.citation = sb.toString();
		}
		
	}

