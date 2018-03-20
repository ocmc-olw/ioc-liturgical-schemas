package org.ocmc.ioc.liturgical.schemas.constants;

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
public enum NOTE_TYPES {

ADVICE_FOR_TRANSLATORS("TNAFT","Advice - for Translators")
, ADVICE_FOR_TRANSLATION_CHECKERS("TNAFC","Advice - for Translation Checkers")
, CULTURE("TNAC","Culture")
, GENERAL("TNGEO","General")
, GEOGRAPHY("TNGEO","Geography")
, GRAMMAR("TNLINGGRAM","Grammar")
, HISTORY("TNH","History")
, LITURGICAL_USAGE("TNLITURGYUSE","Liturgical Usage")
, MEANING("TNMEAN","Meaning")
, REF_TO_ANIMAL("TNONTOANIMAL", "Reference - to Animal")
, REF_TO_BEING("TNONTOBEING", "Reference - to Being")
, REF_TO_BIBLE("TNONTOBIBLE", "Reference - to Bible")
, REF_TO_CONCEPT("TNONTOCONC", "Reference - to Concept")
, REF_TO_EVENT("TNONTOEVENT", "Reference - to Event")
, REF_TO_GOD("TNONTOGOD", "Reference - to God")
, REF_TO_GROUP("TNONTOGROUP", "Reference - to Group")
, REF_TO_HUMAN("TNONTOHUM", "Reference - to Human")
, REF_TO_MYSTERY("TNONTOMYS", "Reference - to Mystery")
, REF_TO_OBJECT("TNONTOOBJ", "Reference - to Object")
, REF_TO_PLACE("TNONTOPLACE", "Reference - to Place")
, REF_TO_PLANT("TNONTOPLANT", "Reference - to Plant")
, REF_TO_ROLE("TNONTOROLE", "Reference - to Role")
, TRANSLATORS_NOTE("TNTN","Translator's Note")
, VOCABULARY("TNV","Vocabulary")
;

	public String keyname = "";
	public String fullname = "";
	
	private NOTE_TYPES(
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
	 * @param includeAny if true will add to the top an object that is value=*, label=any
	 * @return a JsonArray of Dropdowns 
	 */
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (NOTE_TYPES e : NOTE_TYPES.values()) {
    		result.add(new DropdownItem(e.fullname, e.name()).toJsonObject());
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
    	for (NOTE_TYPES e : NOTE_TYPES.values()) {
    		result.add(new DropdownItem(e.fullname, e.name()));
    	}
    	return result;
    }
		
}
