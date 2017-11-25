package org.ocmc.ioc.liturgical.schemas.models.db.docs.tables;

import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

	@Attributes(title = "Data for a react-bootstrap-table", description = "react-bootstrap-table processes data from an array of objects, where each object becomes a row in the table.  This class holds a map with data for a specific type of table.")
	public class ReactBootstrapTableData extends LTKDb  {
		private static String schema = ReactBootstrapTableData.class.getSimpleName();
		private static double serialVersion = 1.1;

		@Attributes(required = true, description = "Json string of the table data")
		@Expose String data = "";
		
		public ReactBootstrapTableData(
				TOPICS topic
				, String key
				) {
			super(
					LIBRARIES.TABLES.toSystemDomain()
					, topic.label
					, key
					, schema
					, serialVersion
					, topic
			);
		}

		public String getData() {
			return data;
		}

		public void setData(String data) {
			this.data = data;
		}
	

}
