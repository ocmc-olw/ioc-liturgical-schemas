package org.ocmc.ioc.liturgical.schemas.models.abbreviations;

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

	// see the OCMC github project for abbreviations as the source of data for an initial load.
	
	/**
	 * Provides a model for recording information about a Github Repo
	 * that will be synched
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Abbreviation", description = "This is a doc that records information about an abbreviation.")
	public class Abbreviation extends LTKLite {
		private static final Logger logger = LoggerFactory.getLogger(Abbreviation.class);
		private static String schema = Abbreviation.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(required = true, description = "Abbreviation")
		@Expose public String abbreviation = "";

		@Attributes(required = true, description = "What the abbreviation means")
		@Expose public String value = "";

		public Abbreviation(
				String topic // of the abbreviation
				, String abbreviation
				, String value
				)  {
			super(
					Constants.LIBRARY_ABBREVIATION
					, topic
					, abbreviation
					, schema
					, version
					);
			this.setPrettyPrint(false);
			this.abbreviation = abbreviation;
			this.value = value;
		}


	}

