package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_GENDER {
	MASC(
			"Masc"
			, "masculine gender"
			, "Nouns denoting male persons are masculine. Other nouns may be also grammatically masculine, without any relation to sex."
			,""
			, ""
			)
	, FEM(
		"Fem"
		, "femine gender"
		, "Nouns denoting female persons are feminine. Other nouns may be also grammatically feminine, without any relation to sex."
		,""
		, ""
		)
	, NEUT(
			"Neut"
			, "neuter gender"
			, "Some languages have only the masculine/feminine distinction while others also have this third gender for nouns that are neither masculine nor feminine (grammatically)."
			,""
			, ""
			)
	, TBD(
			"TBD"
			,"to-be-determined"
			,"to be explained"
			,"tbd"
			, ""
			)
	;
	public String keyname = "";
	public String fullname = "";
	public String decription = "";
	public String parse = "";
	public String gev = "";
	
	private UD_GENDER(
			String keyname
			, String fullname
			, String description
			, String parse
			, String gev
			) {
		this.keyname = keyname;
		this.fullname = fullname;
		this.decription = description;
		this.parse = parse;
		this.gev = gev;
	}
		
	/**
	 * Find the Enum value for this keyname
	 * @param name to search for
	 * @return Entry the enum for that name
	 */
	public static UD_GENDER forName(String name) {
		for (UD_GENDER v : UD_GENDER.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_GENDER.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_GENDER e : UD_GENDER.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_GENDER e : UD_GENDER.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
