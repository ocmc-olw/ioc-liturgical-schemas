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
public class VersionRealm extends LTKDb {
	private static String schema = VersionRealm.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose public String acronymn = ""; 
	@Expose public String desc = ""; 
	@Expose public String area = ""; 
	@Expose public String countryCode = ""; 
	@Expose public String countryName = ""; 

	public VersionRealm(
			String acronymn
			)  {
		super(
				LIBRARIES.TABLES.toSystemDomain()
				, TOPICS.TABLE_REALMS.label
				, acronymn
				, schema
				, version
				, TOPICS.TABLE_REALMS
				);
		this.acronymn = acronymn;
		this.setPrettyPrint(false);
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getAcronymn() {
		return acronymn;
	}

	public void setAcronymn(String acronymn) {
		this.acronymn = acronymn;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
