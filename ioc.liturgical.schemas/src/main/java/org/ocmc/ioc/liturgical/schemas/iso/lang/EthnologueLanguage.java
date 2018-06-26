package org.ocmc.ioc.liturgical.schemas.iso.lang;


import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.annotations.Expose;

/**
 * Provides a model for languages from the Ethnologue
 * 
 * @author mac002
 *
 */
public class EthnologueLanguage extends LTKLite {
	private static String schema = EthnologueLanguage.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose public String area = ""; 
	@Expose public String countryCode = ""; 
	@Expose public String countryName = ""; 
	@Expose public String countryNameLocal = ""; 
	@Expose public String languageCode = ""; 
	@Expose public String languageCodeTwo = ""; 
	@Expose public String languageName = ""; 
	@Expose public String languageNameLocal = ""; 

	public EthnologueLanguage(
			String countryCode
			, String languageCode
			)  {
		super(
				Constants.LIBRARY_ETHNOLOGUE
				, countryCode
				, languageCode
				, schema
				, version
				);
		this.setPrettyPrint(false);
		this.countryCode = countryCode;
		this.languageCode = languageCode;
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

	public String getLanguageCode() {
		return languageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}

	public String getLanguageCodeTwo() {
		return languageCodeTwo;
	}

	public void setLanguageCodeTwo(String languageCodeTwo) {
		this.languageCodeTwo = languageCodeTwo;
	}

	public String getLanguageName() {
		return languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	public String getCountryNameLocal() {
		return countryNameLocal;
	}

	public void setCountryNameLocal(String countryNameLocal) {
		this.countryNameLocal = countryNameLocal;
	}

	public String getLanguageNameLocal() {
		return languageNameLocal;
	}

	public void setLanguageNameLocal(String languageNameLocal) {
		this.languageNameLocal = languageNameLocal;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
