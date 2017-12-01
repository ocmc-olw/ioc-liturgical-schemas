package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.ocmc.ioc.liturgical.schemas.constants.BIBLICAL_BOOKS;

public class DROPDOWN_VALUES {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
    	map.putAll(BIBLICAL_BOOKS.getMap());
    	map.putAll(LITURGICAL_BOOKS.getMap());
    	map.putAll(DAYS_OF_MONTH.getMap());
    	map.putAll(DAYS_OF_WEEK.getMap());
    	map.putAll(DAYS_OF_TRIODION.getMap());
    	map.putAll(DAYS_OF_PENTECOSTARION.getMap());
    	map.putAll(DOMAINS_BIBLICAL.getMap());
    	map.putAll(DOMAINS_LITURGICAL.getMap());
    	map.putAll(MODES.getMap());
    	map.putAll(HIERATIKON_SECTIONS.getMap());
    	map.putAll(HOROLOGION_SECTIONS.getMap());
    	map.putAll(HEIRMOI_TYPES.getMap());
    	map.putAll(EOTHINON_WEEKS.getMap());
    	map.putAll(MONTHS_OF_YEAR_MAP.getMap());
    	
        map = Collections.unmodifiableMap(map);
	}
    
    public static boolean containsKey(String key) {
    	return map.containsKey(key);
    }
    
    public static String get(String key) {
    	return map.get(key);
    }
    
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
        	return key;
    	}
    }

}
