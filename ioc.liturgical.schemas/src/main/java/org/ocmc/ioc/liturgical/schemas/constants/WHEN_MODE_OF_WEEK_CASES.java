package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum WHEN_MODE_OF_WEEK_CASES {
    MODE1("M1", "Mode 1 (Ἦχος αʹ)")
    ,MODE2("M2", "Mode 2 (Ἦχος βʹ)")
    ,MODE3("M3", "Mode 3 (Ἦχος γʹ)")
    ,MODE4("M4", "Mode 4 (Ἦχος δʹ)")
    ,MODE5("M5", "Mode 5 (Ἦχος πλ. αʹ)")
    ,MODE6("M6", "Mode 6 (Ἦχος πλ. βʹ)")
    ,MODE7("M7", "Mode 7 (Ἦχος βαρύς)")
    ,MODE8("M8", "Mode 8 (Ἦχος πλ. δʹ)")
	;

	public String keyname = "";
	public String fullname = "";
	
	private WHEN_MODE_OF_WEEK_CASES(
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
    	for (WHEN_MODE_OF_WEEK_CASES e : WHEN_MODE_OF_WEEK_CASES.values()) {
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
    	for (WHEN_MODE_OF_WEEK_CASES e : WHEN_MODE_OF_WEEK_CASES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
