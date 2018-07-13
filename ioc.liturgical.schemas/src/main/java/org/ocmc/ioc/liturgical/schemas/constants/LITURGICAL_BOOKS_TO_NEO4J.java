package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

public class LITURGICAL_BOOKS_TO_NEO4J {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
//        map.put("le.ep", "Lectionary - Apostolos (ὁ Ἀπόστολος)");
//        map.put("da", "Daily Hymns of the Week (Της Όλης Εβδομάδος)");
//        map.put("eo", "Eothina (τά ἑωθινά)");
        map.put("eu", "misc~book.Euchologion.name");
//        map.put("le.go", "Lectionary - Evangelion (τό εὐαγγέλιον)");
        map.put("he", "misc~book.Heirmologion.name");
        map.put("hi", "misc~book.Hieratikon.name");
        map.put("ho", "misc~book.Horologion.name");
        map.put("me.su", "misc~book.MeSupplement.name"); // don't know if key is correct
        map.put("me", "misc~book.Menaion.name");
        map.put("oc", "misc~book.Octoechos.name");
        map.put("pe", "misc~book.Pentecostarion.name");
        map.put("pe.su", "misc~book.PeSupplement.name"); // do not know if key is correct
//        map.put("le.pr", "Lectionary - Prophetologion (τό Προφητολόγιον)");
        map.put("ps", "misc~book.Psalter.name");
        map.put("sy", "misc~book.Synaxarion.name");
        map.put("tr", "misc~book.Triodion.name)");
        map.put("tu", "misc~book.Typikon.name)"); // do not know if key is correct
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

    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	result.add(new DropdownItem("Any", "*"));
    	for (Entry<String,String> entry : map.entrySet()) {
    		result.add(new DropdownItem(entry.getValue(), entry.getKey()));
    	}
    	return result;
    }

}
