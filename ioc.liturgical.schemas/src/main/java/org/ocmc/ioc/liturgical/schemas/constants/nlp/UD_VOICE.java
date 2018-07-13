package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_VOICE {
	ACT(
			"Act"
			, "active voice"
			, "The subject of the verb is the doer of the action (agent), the object is affected by the action (patient)."
			,""
			, ""
			)
	, MID(
		"Mid"
		, "middle voice"
		, "Between active and passive."
		,""
		, ""
		)
	, PASS(
			"Pass"
			, "passive voice"
			, "The subject of the verb is affected by the action (patient). The doer (agent) is either unexpressed or it appears as an object of the verb."
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
	
	private UD_VOICE(
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
	public static UD_VOICE forName(String name) {
		for (UD_VOICE v : UD_VOICE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_VOICE.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_VOICE e : UD_VOICE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_VOICE e : UD_VOICE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
