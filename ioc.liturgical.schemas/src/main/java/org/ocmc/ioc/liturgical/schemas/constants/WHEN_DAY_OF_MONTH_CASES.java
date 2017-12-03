package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum WHEN_DAY_OF_MONTH_CASES {
	D01("D01", "D01")
	, D02("D02", "D02")
	, D03("D03", "D03")
	, D04("D04", "D04")
	, D05("D05", "D05")
	, D06("D06", "D06")
	, D07("D07", "D07")
	, D08("D08", "D08")
	, D09("D09", "D09")
	, D10("D10", "D10")
	, D11("D11", "D11")
	, D12("D12", "D12")
	, D13("D13", "D13")
	, D14("D14", "D14")
	, D15("D15", "D15")
	, D16("D16", "D16")
	, D17("D17", "D17")
	, D18("D18", "D18")
	, D19("D19", "D19")
	, D20("D20", "D20")
	, D21("D21", "D21")
	, D22("D22", "D22")
	, D23("D23", "D23")
	, D24("D24", "D24")
	, D25("D25", "D25")
	, D26("D26", "D26")
	, D27("D27", "D27")
	, D28("D28", "D28")
	, D29("D29", "D29")
	, D30("D30", "D30")
	, D31("D31", "D31")
	;

	public String keyname = "";
	public String fullname = "";
	
	private WHEN_DAY_OF_MONTH_CASES(
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
    	for (WHEN_DAY_OF_MONTH_CASES e : WHEN_DAY_OF_MONTH_CASES.values()) {
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
    	for (WHEN_DAY_OF_MONTH_CASES e : WHEN_DAY_OF_MONTH_CASES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
