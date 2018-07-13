package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_PERSON {
	FIRST(
			"1"
			, "first person"
			, "In singular, the first person refers just to the speaker / author. In plural, it must include the speaker and one or more additional persons."
			,""
			, ""
			)
	, 	SECOND(
			"2"
			, "second person"
			, "In singular, the second person refers to the addressee of the utterance / text. In plural, it may mean several addressees and optionally some third persons too."
			,""
			, ""
			)
	, 	THIRD(
			"3"
			, "third person"
			, "The third person refers to one or more persons that are neither speakers nor addressees."
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
	
	private UD_PERSON(
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
	public static UD_PERSON forName(String name) {
		for (UD_PERSON v : UD_PERSON.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_PERSON.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_PERSON e : UD_PERSON.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_PERSON e : UD_PERSON.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
