package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

public class LITURGICAL_BOOKS {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("le.ep", "Lectionary - Apostolos (ὁ Ἀπόστολος)");
        map.put("da", "Daily Hymns of the Week (Της Όλης Εβδομάδος)");
        map.put("eo", "Eothina (τά ἑωθινά)");
        map.put("eu", "Euchologion (τό Εὐχολόγιον)");
        map.put("le.go", "Lectionary - Evangelion (τό εὐαγγέλιον)");
        map.put("he", "Heirmologion (τό Εἱρμολόγιον)");
        map.put("hi", "Hieratikon (τό Ἱερατικὸν)");
        map.put("ho", "Horologion (τό ῾Ωρλόγιον)");
        map.put("me", "Menaion (τά Μηναῖα)");
        map.put("oc", "Octoechos (ἡ Παρακλητική)");
        map.put("pe", "Pentecostarion (τό Πεντηκοστάριον)");
        map.put("le.pr", "Lectionary - Prophetologion (τό Προφητολόγιον)");
        map.put("ps", "Psalterion (τό Ψαλτήριον)");
        map.put("sy", "Synaxarion (τό Συναξάριον)");
        map.put("tr", "Triodion (τό Τριῴδιον)");
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
    		return get(key);
    	} else {
    		return key;
    	}
    }
    
    public static Map<String,String> getMap() {
    	return map;
    }

    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	result.add(new DropdownItem("Any", "*"));
    	for (Entry<String,String> entry : map.entrySet()) {
    		result.add(new DropdownItem(entry.getValue(), entry.getKey()));
    	}
    	return result;
    }

}
