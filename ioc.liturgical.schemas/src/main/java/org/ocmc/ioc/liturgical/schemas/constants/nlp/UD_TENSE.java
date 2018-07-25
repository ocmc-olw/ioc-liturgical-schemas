package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_TENSE {
	PAST(
			"Past"
			, "past tense"
			, "The past tense denotes actions that happened before a reference point. In the prototypical case, the reference point is the moment of producing the sentence and the past event happened before the speaker speaks about it. However, Tense=Past is also used to distinguish past participles from other kinds of participles, and past converbs from other kinds of converbs; in these cases, the reference point may itself be in past or future, when compared to the moment of speaking. "
			,""
			, ""
			)
	, PRES(
		"Pres"
		, "present tense"
		, "The present tense denotes actions that are in progress (or states that are valid) in a reference point; it may also describe events that usually happen. In the prototypical case, the reference point is the moment of producing the sentence; however, Tense=Pres is also used to distinguish present participles from other kinds of participles, and present converbs from other kinds of converbs. In these cases, the reference point may be in past or future when compared to the moment of speaking. "
		,""
		, ""
		)
	, FUT(
			"Fut"
			, "future tense"
			, "The future tense denotes actions that will happen after a reference point; in the prototypical case, the reference point is the moment of producing the sentence."
			,""
			, ""
			)
	, IMP(
			"Imp"
			, "Imperfect"
			, ""
			,""
			, ""
			)
	, PQP(
			"Pqp"
			, "pluperfect"
			, "The pluperfect denotes action that happened before another action in past. "
			,""
			, ""
			)
	, USP(
			"_"
			,"unspecified"
			,"unspecified"
			,""
			, ""
			)
	;
	public String keyname = "";
	public String fullname = "";
	public String decription = "";
	public String parse = "";
	public String gev = "";
	
	private UD_TENSE(
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
	public static UD_TENSE forName(String name) {
		for (UD_TENSE v : UD_TENSE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_TENSE.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_TENSE e : UD_TENSE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_TENSE e : UD_TENSE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
