package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MODES_TO_NEO4J {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("m0", "misc~Mode");  // the word Mode without saying which one
        map.put("m1", "misc~Mode1");
        map.put("m2", "misc~Mode2");
        map.put("m3", "misc~Mode3");
        map.put("m4", "misc~Mode4");
        map.put("m5", "misc~Mode5");
        map.put("m6", "misc~Mode6");
        map.put("m7", "misc~Mode7");
        map.put("m8", "misc~Mode8");
        
        map = Collections.unmodifiableMap(map);
	}
    
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return key + " - " + map.get(key);
    }
    
    public static String getValue(String key) {
    	if (map.containsKey(key)) {
    		return map.get(key);
    	} else {
    		return key;
    	}
    }
    
    public static String getAgesId(String key, String library) {
    	StringBuffer result = new StringBuffer();
    	String value = MODES_TO_NEO4J.getValue(key);
    	result.append("misc_");
    	result.append(library);
    	result.append("|mode");
    	result.append(key.substring(1));
    	return result.toString();
    }
    
    public static String getNeo4jId(String key, String library) {
    	StringBuffer result = new StringBuffer();
    	result.append(library);
    	result.append("~");
    	result.append(MODES_TO_NEO4J.getValue(key));
    	return result.toString();
    }

    public static Map<String,String> getMap() {
    	return map;
    }

}
