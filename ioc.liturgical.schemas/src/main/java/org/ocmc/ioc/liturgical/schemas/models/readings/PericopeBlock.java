package org.ocmc.ioc.liturgical.schemas.models.readings;

	import org.ocmc.ioc.liturgical.schemas.constants.BIBLICAL_BOOKS_ENUM;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.DATA_SOURCES;
import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Human;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import com.github.reinert.jjschema.Attributes;
	import com.google.gson.annotations.Expose;

	
	/**
	 * Provides a model for meta-data about daily readings
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Pericope Block", description = "A specific Biblical Book, Chapter, and range of verses")
	public class PericopeBlock extends LTKDb {
		
		private static final Logger logger = LoggerFactory.getLogger(PericopeBlock.class);
		private static String schema = PericopeBlock.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(id="top", required = true, description = "Book code")
		@Expose BIBLICAL_BOOKS_ENUM book = null;

		@Attributes(id="top", required = true, description = "Chapter Number")
		@Expose String chapter = "";

		@Attributes(id="top", required = true, description = "Starting verse number")
		@Expose String verseFrom = "";

		@Attributes(id="top", required = true, description = "Ending verse number")
		@Expose String verseTo = "";
		
		public PericopeBlock(
				BIBLICAL_BOOKS_ENUM book
				, String chapter
				, String verseFrom
				, String verseTo
				)  {
			super(
					Constants.LIBRARY_READINGS
					, Constants.TOPIC_PERICOPE_BLOCK
					, PericopeBlock.format(book.name(), chapter, verseFrom, verseTo)
					, schema
					, version
					, TOPICS.PERICOPE
					);
			this.book = book;
			this.chapter = "C" + PericopeBlock.pad(chapter);
			this.verseFrom = PericopeBlock.pad(verseFrom);
			this.verseTo = PericopeBlock.pad(verseTo);
			this.setPrettyPrint(false);
		}
		
		public static String pad(String s) {
			return String.format("%03d", s); 
		}
		
		public static String format(String b, String c, String vf, String vt) {
			return b 
			+ "~C" 
				+ PericopeBlock.pad(c) 
				+ ":" 
				+ PericopeBlock.pad(vf) 
				+ "-" 
				+ PericopeBlock.pad(vt)
				;
		}

		public BIBLICAL_BOOKS_ENUM getBook() {
			return book;
		}

		public void setBook(BIBLICAL_BOOKS_ENUM book) {
			this.book = book;
		}

		public String getChapter() {
			return chapter;
		}

		public void setChapter(String chapter) {
			this.chapter = chapter;
		}

		public String getVerseFrom() {
			return verseFrom;
		}

		public void setVerseFrom(String verseFrom) {
			this.verseFrom = verseFrom;
		}

		public String getVerseTo() {
			return verseTo;
		}

		public void setVerseTo(String verseTo) {
			this.verseTo = verseTo;
		}

	}

