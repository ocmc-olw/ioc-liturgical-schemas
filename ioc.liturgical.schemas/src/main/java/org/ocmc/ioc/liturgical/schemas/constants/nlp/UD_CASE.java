package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_CASE {
	NOM(
			"Nom"
			, "nominative"
			, "The base form of the noun, typically used as citation form (lemma). In many languages this is the word form used for subjects of clauses. "
			,""
			, ""
			)
	, ACC(
		"Acc"
		, "accusative"
		, "In many languages this is the word form used for direct objects of verbs. "
		,""
		, ""
		)
	, DAT(
			"Dat"
			, "dative"
			, "In many languages this is the word form used for indirect objects of verbs."
			,""
			, ""
			)
	, GEN(
			"Gen"
			, "genitive"
			, "Prototypical meaning of genitive is that the noun phrase somehow belongs to its governor; it would often be translated by the English preposition of. "
			,""
			, ""
			)
	, VOC(
			"Voc"
			, "vocative"
			, "The vocative case is a special form of noun used to address someone. Thus it predominantly appears with animate nouns (see the feature of Animacy). Nevertheless this is not a grammatical restriction and inanimate things can be addressed as well."
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
	
	private UD_CASE(
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
	public static UD_CASE forName(String name) {
		for (UD_CASE v : UD_CASE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_CASE.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_CASE e : UD_CASE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_CASE e : UD_CASE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
