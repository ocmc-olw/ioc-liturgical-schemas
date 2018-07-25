package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_DEGREE {
	ABS(
			"Abs"
			, "absolute superlative"
			, "Some languages can express morphologically that the studied quality of the given object is so strong that there is hardly any other object exceeding it. The quality is not actually compared to any particular set of objects."
			,""
			, ""
			)
	, CMP(
			"Cmp"
			, "comparative, second degree"
			, "The quality of one object is compared to the same quality of another object."
			,""
			, ""
			)
	, EQU(
		"Equ"
		, "equative"
		, "The quality of one object is compared to the same quality of another object, and the result is that they are identical or similar (“as X as”). Note that it marks the adjective and it is distinct from the equative Case, which marks the standard of comparison."
		,""
		, ""
		)
	, POS(
			"Pos"
			, "positive, first degree"
			, "This is the base form that merely states a quality of something, without comparing it to qualities of others. Note that although this degree is traditionally called “positive”, negative properties can be compared, too."
			,""
			, ""
			)
	, SUP(
			"Sup"
			, "superlative, third degree"
			, "The quality of one object is compared to the same quality of all other objects within a set."
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
	
	private UD_DEGREE(
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
	public static UD_DEGREE forName(String name) {
		for (UD_DEGREE v : UD_DEGREE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_DEGREE.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_DEGREE e : UD_DEGREE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_DEGREE e : UD_DEGREE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
