package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum ABBREVIATION_TYPES {
	USER_DEFINED("userdefabr", "User Defined Abbreviations")
	;

	public String keyname = "";
	public String title = "";
	
	private ABBREVIATION_TYPES(
			String keyname
			, String title
			) {
		this.title = title;
		this.keyname = keyname;
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
    	for (ABBREVIATION_TYPES e : ABBREVIATION_TYPES.values()) {
    		result.add(new DropdownItem(e.title).toJsonObject());
    	}
    	return result;
    }

}
