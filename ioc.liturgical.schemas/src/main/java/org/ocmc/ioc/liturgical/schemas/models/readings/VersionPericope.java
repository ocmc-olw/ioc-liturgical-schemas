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
	 * Provides the text of a pericope for a specific version
	 * 
	 * @author mac002
	 *
	 */
	@Attributes(title = "Pericope", description = "Indicates which Biblical texts to read.")
	public class VersionPericope extends LTKDb {
		private static final Logger logger = LoggerFactory.getLogger(VersionPericope.class);
		private static String schema = VersionPericope.class.getSimpleName();
		private static double version = 1.1;
	
		@Attributes(id="top", required = true, description = "The citation form of the book, chapter, verse for the reading")
		@Expose  public String citation = "";

		@Attributes(id="top", required = true, description = "The text of the pericope.")
		@Expose  public String value = "";
		
		@Attributes(id="top", required = true, description = "Where the readings are used.")
		@Expose  public List<String> whereUsed = new ArrayList<String>();
		
		public VersionPericope(
				String library
				, String key
				)  {
			super(
					library
					, Constants.TOPIC_PERICOPE
					, key
					, schema
					, version
					, TOPICS.PERICOPE
					);
			this.setPrettyPrint(false);
		}
		
		public List<String> getWhereUsed() {
			return whereUsed;
		}

		public void setWhereUsed(List<String> whereUsed) {
			this.whereUsed = whereUsed;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}
		
	}

