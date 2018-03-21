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

ADVICE_FOR_TRANSLATORS("TNAFT","Advice - for Translators", false)
, ADVICE_FOR_TRANSLATION_CHECKERS("TNAFC","Advice - for Translation Checkers", false)
, CULTURE("TNAC","Culture", false)
, GENERAL("TNGEO","General", false)
, GEOGRAPHY("TNGEO","Geography", false)
, GRAMMAR("TNLINGGRAM","Grammar", false)
, LEMMA("TNLEMMA","Lemma", true)
, HISTORY("TNH","History", false)
, LITURGICAL_USAGE("TNLITURGYUSE","Liturgical Usage", false)
, MEANING("TNMEAN","Meaning", false)
, REF_TO_ANIMAL("TNONTOANIMAL", "Reference - to Animal", false)
, REF_TO_BEING("TNONTOBEING", "Reference - to Being", false)
, REF_TO_BIBLE("TNONTOBIBLE", "Reference - to Bible", false)
, REF_TO_CONCEPT("TNONTOCONC", "Reference - to Concept", false)
, REF_TO_EVENT("TNONTOEVENT", "Reference - to Event", false)
, REF_TO_GOD("TNONTOGOD", "Reference - to God", false)
, REF_TO_GROUP("TNONTOGROUP", "Reference - to Group", false)
, REF_TO_HUMAN("TNONTOHUM", "Reference - to Human", false)
, REF_TO_MYSTERY("TNONTOMYS", "Reference - to Mystery", false)
, REF_TO_OBJECT("TNONTOOBJ", "Reference - to Object", false)
, REF_TO_PLACE("TNONTOPLACE", "Reference - to Place", false)
, REF_TO_PLANT("TNONTOPLANT", "Reference - to Plant", false)
, REF_TO_ROLE("TNONTOROLE", "Reference - to Role", false)
, TRANSLATORS_NOTE("TNTN","Translator's Note", false)
, UNIT("TNUNIT","Unit", false)
, VOCABULARY("TNV","Vocabulary", false)
;

	public String keyname = "";
	public String fullname = "";
	public boolean bible_in_liturgy = false;
	
	private NOTE_TYPES(
			String keyname
			, String fullname
			, boolean bil
			) {
		this.keyname = keyname;
		this.fullname = fullname;
		this.bible_in_liturgy = bil;
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
    		if (! e.bible_in_liturgy) {
        		result.add(new DropdownItem(e.fullname, e.name()));
    		}
    	}
    	return result;
    }
		
    public static List<DropdownItem> toDropdownBilList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (NOTE_TYPES e : NOTE_TYPES.values()) {
    		if (e.bible_in_liturgy 
    				|| e == NOTE_TYPES.REF_TO_BIBLE 
    				|| e == NOTE_TYPES.UNIT
    				) {
        		result.add(new DropdownItem(e.fullname, e.name()));
    		}
    	}
    	return result;
    }
}
