package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum USER_INTERFACE_LANGUAGES {
	ALBANIAN("alb","Albanian (Shqiptar)")
	, ARABIC("ara","Arabic (عربى)")
	, CHINESE("zh","Chinese (中文)")
	, ENGLISH("en", "English (Αγγλικά).")
	, FILIPINO("fil","Filipino")
	, FRENCH("fra","French (Français)")
	, GREEK_MODERN("el", "Greek (Ελληνικά )")
	, INDONESIAN("ind","Bahasa Indonesia")
	, JAPANESE("jpn","Japanese (日本語)")
	, KOREAN("kor","Korean (한국어)")
	, MONGOLIAN("mon","Mongolian (Монгол хэл)")
	, RUSSIAN("rus","Russian (Русский)")
	, SPANISH("spa","Spanish (Español)")
	, SWAHILI("swh","Swahili (Kiswahili)")
	;
	public String topic;
	public String description;
	
	private USER_INTERFACE_LANGUAGES(
			String topic
			, String description
			) {
		this.topic = topic;
		this.description = description;
	}

    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (USER_INTERFACE_LANGUAGES e : USER_INTERFACE_LANGUAGES.values()) {
    		result.add(new DropdownItem(e.topic + " - " + e.description, e.topic).toJsonObject());
    	}
    	return result;
    }

    public static List<JsonObject> toDropdownList() {
    	List<JsonObject> result = new ArrayList<JsonObject>();
    	for (USER_INTERFACE_LANGUAGES e : USER_INTERFACE_LANGUAGES.values()) {
    		result.add(new DropdownItem(e.topic + " - " + e.description, e.topic).toJsonObject());
    	}
    	return result;
    }

}
