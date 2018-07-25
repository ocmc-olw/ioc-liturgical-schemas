package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_MOOD {
	IND(
			"Ind"
			, "indicative"
			, "The indicative can be considered the default mood. A verb in indicative merely states that something happens, has happened or will happen, without adding any attitude of the speaker."
			,""
			, ""
			)
	, IMP(
		"Imp"
		, "imperative"
		, "The speaker uses imperative to order or ask the addressee to do the action of the verb."
		,""
		, ""
		)
	, OPT(
			"Opt"
			, "optative"
			, "Expresses exclamations like “May you have a long life!” or “If only I were rich!” "
			,""
			, ""
			)
	, SUB(
			"Sub"
			, "subjunctive"
			, "The subjunctive mood is used under certain circumstances in subordinate clauses, typically for actions that are subjective or otherwise uncertain. In German, it may be also used to convey the conditional meaning."
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
	
	private UD_MOOD(
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
	public static UD_MOOD forName(String name) {
		for (UD_MOOD v : UD_MOOD.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_MOOD.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_MOOD e : UD_MOOD.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_MOOD e : UD_MOOD.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
