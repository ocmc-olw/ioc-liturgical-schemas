package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 *
 * Grammatical Parts of Speech used with Greek
 * 
 * @author mac002
 *
 */
public enum PARTS_OF_SPEECH {
	ADJ("adj", "adjective")
	, ADV("adv", "adverb")
	, ARTICLE("art", "article")
	, CONJ("conj", "conjunction")
	, EXCLA("excla", "exclamation")
	, NOUN("noun", "noun")
	, PART("part", "participle")
	, PREP("prep", "preposition")
	, PRONOUN("pron", "pronoun")
	, UNKNOWN("unk", "unknown")
	, VERB("verb", "verb") 
	;

	public String keyname = "";
	public String fullname = "";
	
	private PARTS_OF_SPEECH(
			String keyname
			, String fullname
			) {
		this.keyname = keyname;
		this.fullname = fullname;
	}

	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return a JsonArray of Dropdowns
	 */
    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (PARTS_OF_SPEECH e : PARTS_OF_SPEECH.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    	}
    	return result;
    }

	/**
	 * Converts the enumeration a List of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return a list of dropdowns
	 */
    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (PARTS_OF_SPEECH e : PARTS_OF_SPEECH.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
