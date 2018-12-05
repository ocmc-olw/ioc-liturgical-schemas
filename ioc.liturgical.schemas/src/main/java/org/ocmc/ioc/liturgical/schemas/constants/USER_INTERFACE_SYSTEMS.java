package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.ocmc.ioc.liturgical.schemas.id.managers.IdManager;
import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public class USER_INTERFACE_SYSTEMS {
    private static  Map<String, String> map = new TreeMap<String,String>();
    static {
		map.put("ilr", "Core - Used by All Systems");
		map.put("olw", "OLW - Used by the Online Liturgical Workstation");
	}
    
    public static List<String> toDomainsForLanguage(String language) {
    	List<String> result = new ArrayList<String>();
    	String lang_country = language + "_sys_";
    	for (String system : map.keySet()) {
    		result.add(lang_country + system);
    	}
    	return result;
    }
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return key + " - " + map.get(key);
    }
    
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
    		return key;
    	}
    }
    
    public static Map<String,String> getMap() {
    	return map;
    }
    
    public static JsonArray toDropdownJsonArray() {
    	JsonArray array = new JsonArray();
    	for (Entry<String,String> entry : map.entrySet()) {
    		array.add(new DropdownItem(entry.getValue(), entry.getKey()).toJsonObject());
    	}
    	return array;
    }

    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (Entry<String,String> entry : map.entrySet()) {
    		result.add(new DropdownItem(entry.getValue(), entry.getKey()));
    	}
    	return result;
    }

}
