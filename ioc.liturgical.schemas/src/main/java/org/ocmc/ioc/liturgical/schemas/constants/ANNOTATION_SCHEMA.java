package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum ANNOTATION_SCHEMA {
	PERSEUS(
			"perseus"
			, "Dependency labels - Perseus, Grammatical Labels: Perseus"
			)
	, HYBRID(
			"hybrid"
			, "Dependency labels - UD, Grammatical Labels: Perseus"
			)
	, UD(
			"ud"
			, "Dependency labels - UD, Grammatical Labels: UD"
			)
	, UNKNOWN(
			"unknown"
			, ""
			)
	;
	
	public String name = "";
	public String description = "";
	
	private ANNOTATION_SCHEMA (
			String name
			, String description 
			) {
		this.name = name;
		this.description = description;
	}
	
	public static ANNOTATION_SCHEMA forName(String name) {
		for (ANNOTATION_SCHEMA v : ANNOTATION_SCHEMA.values()) {
			if (v.name().equals(name)) {
				return v;
			}
		}
		return ANNOTATION_SCHEMA.UNKNOWN;
	}
		
    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (ANNOTATION_SCHEMA e : ANNOTATION_SCHEMA.values()) {
    		result.add(new DropdownItem(e.description, e.name()).toJsonObject());
    	}
    	return result;
    }

}
