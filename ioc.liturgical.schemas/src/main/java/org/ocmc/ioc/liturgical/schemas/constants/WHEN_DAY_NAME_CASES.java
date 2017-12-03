package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum WHEN_DAY_NAME_CASES {
    SUNDAY("D1", "D1 - Sunday (Κυριακή)")
    ,MONDAY("D2", "D2 - Monday (Δευτέρα)")
    ,TUESDAY("D3", "D3 - Tuesday (Τρίτη)")
    ,WEDNESDAY("D4", "D4 - Wednesday (Τετάρτη)")
    ,THURSDAY("D5", "D5 - Thursday (Πέμπτη)")
    ,FRIDAY("D6", "D6 - Friday (Παρασκευή)")
    ,SATURDAY("D7", "D7 - Saturday (Σάββατο)")
	;

	public String keyname = "";
	public String fullname = "";
	
	private WHEN_DAY_NAME_CASES(
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
    	for (WHEN_DAY_NAME_CASES e : WHEN_DAY_NAME_CASES.values()) {
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
    	for (WHEN_DAY_NAME_CASES e : WHEN_DAY_NAME_CASES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
