package org.ocmc.ioc.liturgical.schemas.models.supers;

	import org.ocmc.ioc.liturgical.schemas.constants.BIBLIOGRAPHY_CITATION_OVERRIDE;
import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_ENTRY_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.BIBTEX_SOURCE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
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

		@Attributes(id = "bottom", readonly = true, required = false, description = "Type of Bibliographic Entry")
		@Expose public BIBTEX_ENTRY_TYPES entryType = BIBTEX_ENTRY_TYPES.UNPUBLISHED;
		
		@Attributes(id = "bottom", required = false, description = "Entry is a Primary, Secondary, or Tertiary Source")
		@Expose public BIBTEX_SOURCE_TYPES sourceType = BIBTEX_SOURCE_TYPES.PRIMARY;
		
		@Attributes(id="bottom", required = false, description = "citeoverride: default is NONE.")
		@Expose public BIBLIOGRAPHY_CITATION_OVERRIDE citeoverride = BIBLIOGRAPHY_CITATION_OVERRIDE.NONE;

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
			this.setPartTypeOfTopic(ID_PART_TYPES.BIBLIOGRAPHY);
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

		public BIBTEX_SOURCE_TYPES getSourceType() {
			return sourceType;
		}

		public void setSourceType(BIBTEX_SOURCE_TYPES sourceType) {
			this.sourceType = sourceType;
		}

		public BIBTEX_ENTRY_TYPES getEntryType() {
			return entryType;
		}

		public void setEntryType(BIBTEX_ENTRY_TYPES entryType) {
			this.entryType = entryType;
		}
		
		// must be overridden by subclasses
		public String toBibtex() {
			return "";
		}

		public BIBLIOGRAPHY_CITATION_OVERRIDE getCiteoverride() {
			return citeoverride;
		}

		public void setCiteoverride(BIBLIOGRAPHY_CITATION_OVERRIDE citeoverride) {
			this.citeoverride = citeoverride;
		}
		
	}

