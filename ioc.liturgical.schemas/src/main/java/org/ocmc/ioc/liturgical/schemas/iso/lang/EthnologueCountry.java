package org.ocmc.ioc.liturgical.schemas.iso.lang;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.exceptions.BadIdException;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.annotations.Expose;

/**
 * Provides a model for countries from the Ethnologue
 * 
 * @author mac002
 *
 */
public class EthnologueCountry extends LTKLite {
	private static String schema = EthnologueCountry.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose public String area = ""; 
	@Expose public String countryCode = ""; 
	@Expose public String countryName = ""; 
	@Expose public String countryNameLocal = ""; 

	public EthnologueCountry(
			String countryCode
			)  {
		super(
				Constants.LIBRARY_ETHNOLOGUE
				, Constants.TOPIC_COUNTRY
				, countryCode
				, schema
				, version
				);
		this.countryCode = countryCode;
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

	public String getCountryNameLocal() {
		return countryNameLocal;
	}

	public void setCountryNameLocal(String countryNameLocal) {
		this.countryNameLocal = countryNameLocal;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
