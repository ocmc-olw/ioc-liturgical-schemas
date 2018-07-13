package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DAYS_OF_WEEK_TO_NEO4j {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("d1", "titles~daySunday");
        map.put("d2", "titles~dayMonday");
        map.put("d3", "titles~dayTuesday");
        map.put("d4", "titles~dayWednesday");
        map.put("d5", "titles~dayThursday");
        map.put("d6", "titles~dayFriday");
        map.put("d7", "titles~daySaturday");
        map.put("d1.uc", "titles~daySunday.uc");
        map.put("d2.uc", "titles~dayMonday.uc");
        map.put("d3.uc", "titles~dayTuesday.uc");
        map.put("d4.uc", "titles~dayWednesday.uc");
        map.put("d5.uc", "titles~dayThursday.uc");
        map.put("d6.uc", "titles~dayFriday.uc");
        map.put("d7.uc", "titles~daySaturday.uc");
        map = Collections.unmodifiableMap(map);
	}
    
    public static Map<String,String> getMap() {
    	return map;
    }
    
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return map.get(key);
    }
    
    public static String getValue(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
    		return key;
    	}
    }
    public static String getValueUpper(String key) {
    	String ucKey = key + ".uc";
    	if (map.containsKey(ucKey)) {
    		return get(ucKey);
    	} else {
    		return getValue(key);
    	}
    }
}
