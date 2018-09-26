package org.ocmc.ioc.liturgical.schemas.models.keymap;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.LDOM.LDOM;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

/**
 * 
 * For each URL know to the Web Service, provides
 * a hash of the url text and an LDOM representation.
 *   
 * @author mac002
 *
 */
public class UrlLdom extends LTKLite  {
	private static String schema = LDOM.class.getSimpleName();
	private static double version = 1.1;

	@Expose public String url = "";
	@Expose public int hash = 0;
	@Expose public LDOM ldom = null;


	public UrlLdom(String source) {
		super(
				Constants.LIBRARY_LITURGICAL_DOCUMENT_MODEL
				,Constants.TOPIC_URLS
				, source
				, schema
				, version
				);
		this.url = source;
	}

	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public int getHash() {
		return hash;
	}


	public void setHash(int hash) {
		this.hash = hash;
	}


	public LDOM getLdom() {
		return ldom;
	}


	public void setLdom(LDOM ldom) {
		this.ldom = ldom;
	}

}
