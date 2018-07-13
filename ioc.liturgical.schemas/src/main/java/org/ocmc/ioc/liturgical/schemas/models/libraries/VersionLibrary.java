package org.ocmc.ioc.liturgical.schemas.models.libraries;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.exceptions.BadIdException;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.annotations.Expose;

/**
 * Provides a model for countries from the Ethnologue
 * 
 * @author mac002
 *
 */
public class VersionLibrary extends LTKDb {
	private static String schema = VersionLibrary.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose public String languageCode = ""; 
	@Expose public String countryCode = ""; 
	@Expose public String realm = ""; 
	@Expose public String description = "";

	public VersionLibrary(
			String languageCode
			, String countryCode
			, String realm
			)  {
		super(
				LIBRARIES.TABLES.toSystemDomain()
				, TOPICS.TABLE_LIBRARIES.label
				, languageCode.toLowerCase() 
					+ Constants.ID_DELIMITER 
					+ countryCode.toLowerCase() 
					+ Constants.ID_DELIMITER 
					+ realm
				, schema
				, version
				, TOPICS.TABLE_LIBRARIES
				);
		this.languageCode = languageCode.toLowerCase();
		this.countryCode = countryCode.toLowerCase();
		this.realm = realm;
		this.setPrettyPrint(false);
	}

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getRealm() {
		return realm;
	}

	public void setRealm(String realm) {
		this.realm = realm;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
