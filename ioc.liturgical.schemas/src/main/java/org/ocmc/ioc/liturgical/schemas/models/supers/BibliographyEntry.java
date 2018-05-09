package org.ocmc.ioc.liturgical.schemas.models.supers;

	import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_SOURCE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Human;
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
	public class BibliographyEntry extends LTKDb {

		public BIBTEX_ENTRY_TYPES entryType = BIBTEX_ENTRY_TYPES.UNPUBLISHED;
		
		@Attributes(required = false, description = "Year of Publication")
		@Expose public BIBTEX_SOURCE_TYPES sourceType = BIBTEX_SOURCE_TYPES.PRIMARY;

		public BibliographyEntry(
				String library
				, String key
				, String schema
				, double version
				, BIBTEX_ENTRY_TYPES type
				)  {
			super(
					library
					, Constants.TOPIC_BIBLIOGRAPHY_ENTRY
					, key
					, schema
					, version
					, TOPICS.BIBLIOGRAPHY
					);
			this.setPrettyPrint(false);
			this.entryType = type;
		}

		public static String keyValue(String key, String value) {
			StringBuffer sb = new StringBuffer();
			if (value.length() > 0) {
				sb.append("\t");
				sb.append(key);
				sb.append(" = {");
				sb.append(value);
				sb.append("}, \n");
			}
			return sb.toString();
		}
		
	}

