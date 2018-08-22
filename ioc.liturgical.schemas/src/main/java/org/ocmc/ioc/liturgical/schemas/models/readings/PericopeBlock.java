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
		
		@Attributes(id="bottom", required = true, description = "ID of the Pericope this block belongs to")
		@Expose String pericopeParentId = "";

		@Attributes(id="bottom", required = true, description = "ID of the Pericope this block belongs to")
		@Expose String blockSeqNbr = "";

		public PericopeBlock(
				String pericopeParentId
				, String blockSeqNbr
				, BIBLICAL_BOOKS_ENUM book
				, String chapter
				, String verseFrom
				, String verseTo
				)  {
			super(
					Constants.LIBRARY_READINGS
					, Constants.TOPIC_PERICOPE_BLOCK
					, pericopeParentId + "." + blockSeqNbr
					, schema
					, version
					, TOPICS.PERICOPE
					);
			this.pericopeParentId = pericopeParentId;
			this.blockSeqNbr = blockSeqNbr;
			this.book = book;
			this.chapter = chapter;
			this.verseFrom = verseFrom;
			this.verseTo = verseTo;
			this.setPrettyPrint(false);
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

