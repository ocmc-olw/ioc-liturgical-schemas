package org.ocmc.ioc.liturgical.schemas.models.abbreviations;

	import org.ocmc.ioc.liturgical.schemas.constants.Constants;
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

	// see the OCMC github project for abbreviations as the source of data for an initial load.
	
	/**
	 * Provides a model for recording information about a Github Repo
	 * that will be synched
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Abbreviation", description = "This is a doc that records information about an abbreviation.")
	public class Abbreviation extends LTKDb {
		private static final Logger logger = LoggerFactory.getLogger(Abbreviation.class);
		private static String schema = Abbreviation.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(required = true, description = "What the abbreviation means")
		@Expose public String value = "";

		@Attributes(required = false, description = "The citation key of a bibliographic entry. If you enter a bibliography key here, it means this abbreviation is an alias for a bibliographic entry.")
		@Expose public String aliasForBibRef = "";

		public Abbreviation(
				String library
				, String abbreviation
				, String value
				)  {
			super(
					library
					, Constants.TOPIC_ABBREVIATION
					, abbreviation
					, schema
					, version
					, TOPICS.ABBREVIATION
					);
			this.setPrettyPrint(false);
			this.setPartTypeOfTopic(ID_PART_TYPES.ABBREVIATION);
			this.key = abbreviation;
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getAliasForBibRef() {
			return aliasForBibRef;
		}

		public void setAliasForBibRef(String aliasForBibRef) {
			this.aliasForBibRef = aliasForBibRef;
		}


	}

