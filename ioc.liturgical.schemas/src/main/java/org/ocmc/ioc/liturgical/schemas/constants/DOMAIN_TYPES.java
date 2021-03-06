package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 * Used to set the type of a domain.
 * 
 * Collective: a domain for collective use (by a group, by the public)
 * User: a domain for a specific user.  Each system user has his/her own domain
 *  
 * 
 * @author mac002
 *
 */
public enum DOMAIN_TYPES {
	COLLECTIVE("a domain for collective use") 
	, USER("a domain for use by a specific user") 
	;

	public String keyname = "";
	
	private DOMAIN_TYPES(
			String keyname
			) {
		this.keyname = keyname;
	}

	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return JsonArray of Dropdowns
	 */
    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (DOMAIN_TYPES e : DOMAIN_TYPES.values()) {
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
	 * @return List of Dropdowns
	 */
    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (DOMAIN_TYPES e : DOMAIN_TYPES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
