package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Note that there are annotations that use DOC_TYPES keys but not explicitly.
 * You have to hard code them.  So making a change here won't change them there.
 * Here is the list:
 * Domain.java
 * DomainCreateForm.java
 * 
 * @author mac002
 *
 */
public class DOC_TYPES {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("Biblical", "Biblical Texts");
        map.put("Link", "Link Texts");
        map.put("Liturgical", "Liturgical Texts");
        map.put("Note", "Note Texts");
        map = Collections.unmodifiableMap(map);
	}
    
    public static String[] getKeysAsArray() {
    	return (String[]) map.keySet().toArray();
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
    
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
    		return key;
    	}
    }

}
