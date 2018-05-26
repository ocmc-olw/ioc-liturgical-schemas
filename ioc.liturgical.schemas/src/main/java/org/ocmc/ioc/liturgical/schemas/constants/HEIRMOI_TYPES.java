package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HEIRMOI_TYPES {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("a", "Automela (Αυτόμελα)");
        map.put("h", "Heirmoi (Εἱρμοί)");
        map.put("ga", "General Apolytikia (Απολυτίκια)");
        map.put("k", "Katavasias (Καταβασία)");
        map.put("o", "Other (Ἄλλα)");
        map = Collections.unmodifiableMap(map);
	}
    
    public static Map<String,String> getMap() {
    	return map;
    }
    
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return key + " - " + map.get(key);
    }
    
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return map.get(key);
    	} else {
    		return key;
    	}
    }

}
