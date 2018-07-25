package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_NUM_TYPE {
	CARD(
			"Card"
			, "cardinal numerals"
			, " cardinal number or corresponding interrogative / relative / indefinite / demonstrative word"
			,""
			, ""
			)
	,DIST(
		"Frac"
		, "fraction"
		, "This is a subtype of cardinal numbers, occasionally distinguished in corpora. It may denote a fraction or just the denominator of the fraction. In various languages these words may behave morphologically and syntactically as nouns or ordinal numerals."
		,""
		, ""
		)
	, FRAC(
			"Dual"
			, "dual number"
			, "A dual noun denotes two persons, animals or things."
			,""
			, ""
			)
	,MULT(
			"Mult"
			, "multiplicative numeral or corresponding interrogative / relative / indefinite / demonstrative word"
			, "This is subtype of adjective or adverb."
			,""
			, ""
			)
	,ORD(
			"Ord"
			, "ordinal numeral or corresponding interrogative / relative / indefinite / demonstrative word"
			, "This is subtype of adjective or (in some languages) of adverb."
			,""
			, ""
			)
	, RANGE(
			"Range"
			,"range of values"
			,"e.g. two to five"
			,""
			, ""
			)
	, SET(
			"Set"
			,"number of sets of things; collective numera"
			,"Morphologically distinct class of numerals used to count sets of things, or nouns that are pluralia tantum. Some authors call this type collective numeral."
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
	
	private UD_NUM_TYPE(
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
	public static UD_NUM_TYPE forName(String name) {
		for (UD_NUM_TYPE v : UD_NUM_TYPE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_NUM_TYPE.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_NUM_TYPE e : UD_NUM_TYPE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_NUM_TYPE e : UD_NUM_TYPE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
