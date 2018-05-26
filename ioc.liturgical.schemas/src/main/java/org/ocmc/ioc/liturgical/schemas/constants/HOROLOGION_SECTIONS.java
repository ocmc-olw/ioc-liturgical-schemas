package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class HOROLOGION_SECTIONS {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
    	map.put("s01", "Preliminary Prayers (Προοιμιακή Προσευχή)");
    	map.put("s02", "Midnight Office  (Το Μεσονυκτικόν)");
    	map.put("s03", "Matins  (Ακολουθία του Όρθρου)");
    	map.put("s04", "First Hour (Ωρα Αʹ.)");
    	map.put("s05", "Third Hour (Ωρα Γʹ.)");
    	map.put("s06", "Sixth Hour (Ωρα Ϛʹ.)");
    	map.put("s07", "Typika Service (Ακολουθία των Τυπικών)");
    	map.put("s08", "Lunch Prayers (Ακολουθία της Τραπέζης)");
    	map.put("s09", "Ninth Hour (Ωρα Θʹ.");
    	map.put("s10", "Vespers (Ακολουθία του Εσπερινού)");
    	map.put("s11", "Dinner Prayers (Ευχή της τραπέζης)");
    	map.put("s12", "Great Compline (Μέγα Απόδειπνον)");
    	map.put("s13", "Small Compline  (Μικρόν Απόδειπνον) ");
    	map.put("s14", "Paschal Service (Πασχάλιος Ημερονύκτιος Ακολουθία)");
    	map.put("s15", "Troparia by Month (Τροπάρια των Ακινήτων Κατά Μήνα)");
    	map.put("s16", "Troparia of Triodion (Τροπάρια του Τριωδίον)");
    	map.put("s17", "Troparia of Pentecostarion (Τροπάρια του Πεντηκοστάριον)");
    	map.put("s18", "Resurrectional Apolytikia (Αναστάσιμα Απολυτίκια)");
    	map.put("s19", "Weekday Apolytikia (Απολυτίκια της Όλης Εβδομάδος)");
    	map.put("s20", "Theotokia by Mode and Day (Θεοτοκία εις Έκαστον Ήχον)");
    	map.put("s21", "Communion Prayers (Προσευχές της Θείας Κοινωνίας)");
    	map.put("s22", "Salutations / Akathist to Theotokos (Ακολουθία του Ακαθίστου Ύμνου εις την Υπεραγίαν Θεοτόκον)");
    	map.put("s23", "Small Paraklesis (Ακολουθία του  Μικρού Παρακλητικού Κανόνας)");
    	map.put("s24", "Great Paraklesis (Ακολουθία του  Μεγάλου Παρακλητικού Κανόνας)");
    	map.put("s25", "Supplication Canon to Lord Jesus (Κανών εις τον Κύριον Ημών Ιησούν Χριστόν)");
    	map.put("s26", "Supplication Canon to Guardian Angel (Κανών εις τον Φύλακα Άγγελον)");
    	map.put("s27", "Supplication Canon to Angels and Saints (Κανών εις  τας Δυνάμεις και εις Πάντας τους Αγίους)");
    	map.put("s28", "Akathist to the Cross (Οίκοι εις τον Τιμίον Σταυρού)");
    	map.put("s29", "Canon, Oikoi, and Hymns to the Holy Trinity (Κανών, Οίκοι, και Ύμνοι εις την Αγίαν Τριάδα)");
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
