package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 *
 * Meta usages.
 * Hidden means it occurs in the body of the command, but is not parameter
 * Mandatory means it is an obligatory command parameter
 * Optional means it is an optional command parameter
 * @author mac002
 *
 */
public enum META_TEXT_USAGES {
MANDATORY("Mandatory","m")
, OPTIONAL("Optional","g")
, HIDDEN("Hidden", "h")
;

	public String keyname = "";
	public String latex = "";
	
	private META_TEXT_USAGES(
			String keyname
			, String latex
			) {
		this.keyname = keyname;
		this.latex = latex;
	}
	
	public static META_TEXT_USAGES getTypeForName(String name) {
    	for (META_TEXT_USAGES e : META_TEXT_USAGES.values()) {
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
    	for (META_TEXT_USAGES e : META_TEXT_USAGES.values()) {
    		result.add(new DropdownItem(e.latex, e.name()).toJsonObject());
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
    	for (META_TEXT_USAGES e : META_TEXT_USAGES.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
		
    public static List<DropdownItem> toDropdownBilList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (META_TEXT_USAGES e : META_TEXT_USAGES.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
}
