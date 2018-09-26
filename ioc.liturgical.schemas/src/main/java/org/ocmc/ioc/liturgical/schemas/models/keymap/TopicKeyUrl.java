package org.ocmc.ioc.liturgical.schemas.models.keymap;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.LDOM.AgesIndexTableRowData;
import org.ocmc.ioc.liturgical.schemas.models.LDOM.LDOM;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

/**
 * 
 * For each topic~key from the data-keys in each html page
 * known to the web service, provides a map.
 * 
 * That is, provides the means to do a search to retrieve the
 * AgesIndexRowData for each combination of topic~key and
 * url.
 *   
 * @author mac002
 *
 */
public class TopicKeyUrl extends LTKLite  {
	private static String schema = LDOM.class.getSimpleName();
	private static double version = 1.1;

	@Expose public AgesIndexTableRowData rowData;

	public TopicKeyUrl(String topicKey, String url) {
		super(
				Constants.LIBRARY_HTML_INDEX
				,topicKey
				, url
				, schema
				, version
				);
	}

	public AgesIndexTableRowData getRowData() {
		return rowData;
	}

	public void setRowData(AgesIndexTableRowData rowData) {
		this.rowData = rowData;
	}

}
