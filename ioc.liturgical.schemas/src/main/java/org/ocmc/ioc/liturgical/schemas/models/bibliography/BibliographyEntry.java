package org.ocmc.ioc.liturgical.schemas.models.bibliography;

	import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Human;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;

	import com.github.reinert.jjschema.Attributes;
	import com.google.gson.annotations.Expose;

	// see https://github.com/dcpurton/biblatex-sbl/blob/master/doc/biblatex-sbl.bib
	// Need to create subtypes and add to the TOPICS, etc.
	
	/**
	 * Provides a model for recording information about a Github Repo
	 * that will be synched
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Bibliographical Entry", description = "This is a doc that records information about a bibliographical entry, e.g. an Article, Book, etc.")
	public class BibliographyEntry extends LTKLite {
		private static final Logger logger = LoggerFactory.getLogger(BibliographyEntry.class);
		private static String schema = BibliographyEntry.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(required = true, description = "Citation form of the entry")
		@Expose public String citationAuthor = "";
		
		@Attributes(required = true, description = "Date of publication")
		@Expose public String date = "";
		

		public BibliographyEntry(
				String citationAuthor
				, String date
				)  {
			super(
					Constants.LIBRARY_BIBLIOGRAPHY
					, Constants.TOPIC_BIBLIOGRAPHY_ENTRY
					, citationAuthor + ":" + date
					, schema
					, version
					);
			this.setPrettyPrint(false);
			this.citationAuthor = citationAuthor;
			this.date = date;
		}


		public String getCitationAuthor() {
			return citationAuthor;
		}


		public void setCitationAuthor(String citationAuthor) {
			this.citationAuthor = citationAuthor;
		}


		public String getDate() {
			return date;
		}


		public void setDate(String date) {
			this.date = date;
		}

	}

