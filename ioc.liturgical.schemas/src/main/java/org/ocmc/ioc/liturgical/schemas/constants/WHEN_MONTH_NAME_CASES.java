package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum WHEN_MONTH_NAME_CASES {
	JAN("Jan", "January")
	, FEB("Feb", "February")
	, MAR("Mar", "March")
	, APR("Apr", "April")
	, MAY("May", "May")
	, JUN("Jun", "June")
	, JUL("Jul", "July")
	, AUG("Aug", "August")
	, SEP("Sep", "September")
	, OCT("Oct", "October")
	, NOV("Nov", "November")
	, DEC("Dec", "December")	;

	public String keyname = "";
	public String fullname = "";
	
	private WHEN_MONTH_NAME_CASES(
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
    	for (WHEN_MONTH_NAME_CASES e : WHEN_MONTH_NAME_CASES.values()) {
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
    	for (WHEN_MONTH_NAME_CASES e : WHEN_MONTH_NAME_CASES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
