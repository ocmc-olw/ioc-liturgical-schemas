package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum ANSWER_TO {
	WHAT_BY(
			"whatBy"
			, "What by"
			)
	, WHAT_TO(
			"whatTo"
			, "What to"
			)
	, WHAT_FOR(
			"whatFor"
			, "What for"
			)
	, WHAT_ABOUT(
			"whatAbout"
			, "What About"
			)
	, WHO_BY(
			"whoBy"
			, "Who by"
			)
	, WHO_TO(
			"whoTo"
			, "Who to"
			)
	, WHO_FOR(
			"whoFor"
			, "Who for"
			)
	, WHAT(
			"what"
			, "What"
			)
	, WHEN(
			"when"
			, "When"
			)
	, WHERE(
			"where"
			, "Where"
			)
	, WHY(
			"why"
			, "Why"
			)
	, HOW(
			"How"
			, "How"
			)
	, HOW_MUCH(
			"howMuch"
			, "How much"
			)
	, TBD(
			"TBD"
			,"to-be-determined"
			)
	;
	public String keyname = "";
	public String fullname = "";
	
	private ANSWER_TO(
			String keyname
			, String fullname
			) {
		this.keyname = keyname;
		this.fullname = fullname;
	}
		
	/**
	 * Find the Enum value for this keyname
	 * @param name to search for
	 * @return Entry the enum for that name
	 */
	public static ANSWER_TO forName(String name) {
		for (ANSWER_TO v : ANSWER_TO.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return ANSWER_TO.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (ANSWER_TO e : ANSWER_TO.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (ANSWER_TO e : ANSWER_TO.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
