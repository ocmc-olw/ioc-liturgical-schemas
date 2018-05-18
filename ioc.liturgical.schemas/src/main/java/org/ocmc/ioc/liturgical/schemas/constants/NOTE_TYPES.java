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

ADVICE_FOR_TRANSLATORS("TNAFT","Advice - for Translators", false, "ADVICE FOR TRANSLATOR")
, ADVICE_FOR_TRANSLATION_CHECKERS("TNAFC","Advice - for Translation Checkers", false, "ADVICE FOR TRANSLATION CHECKER")
, CHECK_YOUR_BIBLE("TNCYB","Check Your Bible", false, "CHECK YOUR BIBLE")
, CULTURE("TNAC","Culture", false, "CULTURE")
, GENERAL("TNGEO","General", false, "GENERAL")
, GEOGRAPHY("TNGEO","Geography", false, "GEOGRAPHY")
, GRAMMAR("TNLINGGRAM","Grammar", false, "GRAMMAR")
, LEMMA("TNLEMMA","Lemma", true, "LEMMA")
, HISTORY("TNH","History", false, "HISTORY")
, LITURGICAL_USAGE("TNLITURGYUSE","Liturgical Usage", false, "LITURGICAL USAGE")
, MEANING("TNMEAN","Meaning", false, "MEANING")
, REF_TO_ANIMAL("TNONTOANIMAL", "Reference - to Animal", false, "REFERS TO ANIMAL")
, REF_TO_BEING("TNONTOBEING", "Reference - to Being", false, "REFERS TO BEING")
, REF_TO_BIBLE("TNONTOBIBLE", "Reference - to Bible", false, "REFERS TO BIBLE")
, REF_TO_CONCEPT("TNONTOCONC", "Reference - to Concept", false, "REFERS TO CONCEPT")
, REF_TO_EVENT("TNONTOEVENT", "Reference - to Event", false, "REFERS TO EVENT")
, REF_TO_GOD("TNONTOGOD", "Reference - to God", false, "REFERS TO GOD")
, REF_TO_GROUP("TNONTOGROUP", "Reference - to Group", false, "REFERS TO GROUP")
, REF_TO_HUMAN("TNONTOHUM", "Reference - to Human", false, "REFERS TO HUMAN")
, REF_TO_MYSTERY("TNONTOMYS", "Reference - to Mystery", false, "REFERS TO MYSTERY")
, REF_TO_OBJECT("TNONTOOBJ", "Reference - to Object", false, "REFERS TO OBJECT")
, REF_TO_PLACE("TNONTOPLACE", "Reference - to Place", false, "REFERS TO PLACE")
, REF_TO_PLANT("TNONTOPLANT", "Reference - to Plant", false, "REFERS TO PLANT")
, REF_TO_ROLE("TNONTOROLE", "Reference - to Role", false, "REFERS TO ROLE")
, TRANSLATORS_NOTE("TNTN","Translator's Note", false, "TRANLATOR'S NOTE")
, UNIT("TNUNIT","Unit", false, "SUMMARY")
, VOCABULARY("TNV","Vocabulary", false, "VOCABULARY")
;

	public String keyname = "";
	public String fullname = "";
	public String notename = "";
	public boolean bible_in_liturgy = false;
	
	private NOTE_TYPES(
			String keyname
			, String fullname
			, boolean bil
			, String notename
			) {
		this.keyname = keyname;
		this.fullname = fullname;
		this.bible_in_liturgy = bil;
		this.notename = notename;
	}
	
	public static NOTE_TYPES getTypeForName(String name) {
    	for (NOTE_TYPES e : NOTE_TYPES.values()) {
    		if (e.name().equals(name)) {
    			return e;
    		}
    	}
    	return null;
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
