package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_NUMBER {
	SING(
			"Sing"
			, "singular number"
			, "A singular noun denotes one person, animal or thing."
			,""
			, ""
			)
	, PLUR(
		"Plur"
		, "plural number"
		, "A plural noun denotes several persons, animals or things."
		,""
		, ""
		)
	, DUAL(
			"Dual"
			, "dual number"
			, "A dual noun denotes two persons, animals or things."
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
	
	private UD_NUMBER(
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
	public static UD_NUMBER forName(String name) {
		for (UD_NUMBER v : UD_NUMBER.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_NUMBER.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_NUMBER e : UD_NUMBER.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_NUMBER e : UD_NUMBER.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
