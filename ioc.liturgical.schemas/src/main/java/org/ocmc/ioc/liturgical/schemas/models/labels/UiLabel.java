package org.ocmc.ioc.liturgical.schemas.models.labels;

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
	 * Provides a model for recording a label for a user interface.
	 * The realm part of the library should be the system acronym.
	 * For example, en_uk_olw are the English labels for the Online Liturgical Workstation
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "User Interface Label", description = "This is a doc that records a label for a user interface.")
	public class UiLabel extends LTKDb {
		private static final Logger logger = LoggerFactory.getLogger(UiLabel.class);
		private static String schema = UiLabel.class.getSimpleName();
		private static double version = 1.1;

		// the key is the label
		@Attributes(required = true, description = "The value")
		@Expose public String value = "";

		public UiLabel(
				String library
				, String topic
				, String key
				, String value
				)  {
			super(
					library
					, topic
					, key
					, schema
					, version
					, TOPICS.UI_LABEL
					);
			this.setPrettyPrint(false);
			this.setPartTypeOfTopic(ID_PART_TYPES.USER_TEXT);
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	}

