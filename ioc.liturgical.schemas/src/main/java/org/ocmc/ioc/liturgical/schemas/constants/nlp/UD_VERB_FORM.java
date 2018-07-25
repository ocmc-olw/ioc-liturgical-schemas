package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_VERB_FORM {
	FIN(
			"Fin"
			, "finite verb"
			, "Rule of thumb: if it has non-empty Mood, it is finite. "
			,""
			, ""
			)
	, INF(
			"Inf"
			, "infinite"
			, ""
			,""
			, ""
			)
	, PART(
		"Part"
		, "participle"
		, "Participle is a non-finite verb form that shares properties of verbs and adjectives"
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
	
	private UD_VERB_FORM(
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
	public static UD_VERB_FORM forName(String name) {
		for (UD_VERB_FORM v : UD_VERB_FORM.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_VERB_FORM.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_VERB_FORM e : UD_VERB_FORM.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_VERB_FORM e : UD_VERB_FORM.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
