package org.ocmc.ioc.liturgical.schemas.models.readings;

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
	@Attributes(title = "Daily Reading", description = "Provides meta-data for a daily reading.")
	public class DailyReading extends LTKDb {
		private static final Logger logger = LoggerFactory.getLogger(DailyReading.class);
		private static String schema = DailyReading.class.getSimpleName();
		private static double version = 1.1;

		@Attributes(required = true, description = "The date for this reading")
		@Expose public DATA_SOURCES source = DATA_SOURCES.OCA_READINGS;

		@Attributes(required = true, description = "The date for this reading")
		@Expose public String date = "";

		@Attributes(required = true, description = "Epistle for this day")
		@Expose public Pericope epistle;

		@Attributes(required = true, description = "Gospel for this day")
		@Expose public Pericope gospel;

		public DailyReading(
				DATA_SOURCES source
				, String date
				)  {
			super(
					Constants.LIBRARY_READINGS
					, source.name()
					, date
					, schema
					, version
					, TOPICS.DAILY_READING
					);
			this.setPrettyPrint(false);
			this.source = source;
			this.date = date;
		}

		public DATA_SOURCES getSource() {
			return source;
		}

		public void setSource(DATA_SOURCES source) {
			this.source = source;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public Pericope getEpistle() {
			return epistle;
		}

		public void setEpistle(Pericope epistle) {
			this.epistle = epistle;
		}

		public Pericope getGospel() {
			return gospel;
		}

		public void setGospel(Pericope gospel) {
			this.gospel = gospel;
		}

	}

