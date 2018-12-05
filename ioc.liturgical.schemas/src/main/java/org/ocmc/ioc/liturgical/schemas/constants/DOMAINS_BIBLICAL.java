package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class DOMAINS_BIBLICAL {
    private static  Map<String, String> map = new TreeMap<String,String>();
    static {
		map.put("en_uk_kjv", "Bible - English - KJV");
		map.put("en_uk_lxxbrenton", "LXX - English - Brenton");
		map.put("en_uk_lxx2012", "LXX - English - Brenton revision 2012");
		map.put("en_uk_webbe", "Bible - English - WEB British Edition");
	//	map.put("gr_eg_lxxupccata", "LXX - Greek - Codex Alexandrinus (UPC-CAT)");
		map.put("gr_eg_lxxupccatba", "LXX - Greek - Codices Vaticanus and Alexandrinus (UPC-CAT)");
	//	map.put("gr_eg_lxxupccatb", "LXX - Greek - Codex Vaticanus (UPC-CAT)");
	//	map.put("gr_eg_lxxupccatog", "LXX - Greek - Old Greek (UPC-CAT)");
	//	map.put("gr_eg_lxxupccats", "LXX - Greek - Codex Sinaiticus (UPC-CAT)");
	//	map.put("gr_eg_lxxupccatth", "LXX - Greek - Theodotion (UPC-CAT)");
	//	map.put("gr_eg_lxxupccat", "LXX - Greek - Rahlfs (UPC-CAT)");
    //    map.put("gr_gr_ntpt", "NT - Greek - Patriarcal");
		map.put("gr_gr_cog", "Bible - Greek - LXX and Patriarcal NT");
        map.put("heb_il_wlc", "OT - Hebrew - Westminster Leningrad Codex (Groves Center)");
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
}
