package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class MONTHS_OF_YEAR_MAP {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("m01", "January (Ιανουάριος)");
        map.put("m02", "February (Φεβρουάριος)");
        map.put("m03", "March (Μάρτιος)");
        map.put("m04", "April (Απρίλιος)");
        map.put("m05", "May (Μάιος)");
        map.put("m06", "June (Ιούνιος)");
        map.put("m07", "July (Ιούλιος)");
        map.put("m08", "August (Αύγουστος)");
        map.put("m09", "September (Σεπτέμβριος)");
        map.put("m10", "October (Οκτώβριος)");
        map.put("m11", "November (Νοέμβριος )");
        map.put("m12", "December (Δεκέμβριος)");
        map = Collections.unmodifiableMap(map);
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
    
    public static Map<String,String> getMap() {
    	return map;
    }

}
