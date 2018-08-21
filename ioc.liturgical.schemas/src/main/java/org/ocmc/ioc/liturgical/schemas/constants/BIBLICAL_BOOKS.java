package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 * The Rev. Dr. Eugen Pentiuc asked that we use the SBL abbreviations.
 * @author mac002
 *
 */
public class BIBLICAL_BOOKS {
    private static Map<String, String> map = new TreeMap<String,String>();
    static {
        map.put("OT", "OT - Old Testament (Παλαιά Διαθήκη)");
        map.put("GEN", "Gen - Genesis (Γένεσις)");
        map.put("EXO", "Exod - Exodus ( Ἔξοδος)");
        map.put("LEV", "Lev - Leviticus (Λευϊτικόν)");
        map.put("NUM", "Num - Numbers (Ἀριθμοί)");
        map.put("DEU", "Deut - Deuteronomy (Δευτερονόμιον)");
        map.put("JOS", "Josh - Joshua (Ἰησοῦς Nαυῆ)");
        map.put("JDG", "Judg - Judges (Κριταί)");
        map.put("RUT", "Ruth - Ruth (Ῥούθ)");
        map.put("SA1", "1 Sam - I Samuel (Βασιλειῶν Αʹ) - 1 Kingdoms");
        map.put("SA2", "2 Sam - II Samuel (Βασιλειῶν Βʹ) - 2 Kingdoms");
        map.put("KI1", "1 Kgs - I Kings (Βασιλειῶν Γʹ) - 3 Kingdoms");
        map.put("KI2", "2 Kgs - II Kings (Βασιλειῶν Δʹ) - 4 Kingdoms");
        map.put("CH1", "1 Chr - I Chronicles (Παραλειπομένων Αʹ)");
        map.put("CH2", "2 Chr - II Chronicles (Παραλειπομένων Βʹ)");
        map.put("ES1", "1 Esd - 1 Esdras ( Ἔσδρας Αʹ)");
        map.put("ES2", "2 Esd - Ezra-Nehemiah ( Ἔσδρας Βʹ)");
//        map.put("ES4", "4 Esd - 4 Esdras ( Ἔσδρας Δʹ)");
        map.put("EZR", "Ezra - Ezra ( Ἔσδρας)");
        map.put("NEH", "Neh - Nehemiah ( Νεεμίας)");
        map.put("PRA", "Pr Azar - Prayer of Azariah (Προσευχή του Αζαρίου)");
        map.put("PRM", "Pr Man - Prayer of Manasseh (Προσευχή του Μανασσή)");
        map.put("TOB", "Tob - Tobit or Tobias (Τωβίτ)");
        map.put("JDT", "Jdt - Judith (Ἰουδίθ)");
        map.put("EST", "Esth - Esther (Ἐσθήρ)");
        map.put("MA1", "1 Macc - 1 Maccabees (Μακκαβαίων Αʹ)");
        map.put("MA2", "2 Macc - 2 Maccabees (Μακκαβαίων Βʹ)");
        map.put("MA3", "3 Macc - 3 Maccabees (Μακκαβαίων Γʹ)");
        map.put("PSA", "Ps/Pss - Psalm/Psalms (Ψαλμοί)");
        map.put("PSX", "Ps 151 - Psalm 151 (Ψαλμός 151)");
        map.put("ODE", "Ode - Biblical Odes (Εννέα Ωδαί)");
        map.put("JOB", "Job - Job (Ἰώβ)");
        map.put("PRO", "Prov - Proverbs (Παροιμίαι)");
        map.put("ECC", "Eccl - Ecclesiastes (Ἐκκλησιαστής)");
        map.put("SOS", "Song - Song of Solomon or Canticles (Ἆσμα Ἀσμάτων)");
        map.put("WIS", "Wis - Wisdom (Σοφία Σαλoμῶντος)");
        map.put("SIR", "Sir - Sirach or Ecclesiasticus (Σοφία Ἰησοῦ Σειράχ)");
        map.put("POS", "Pss. Sol. - Psalms of Solomon (Ψαλμοί Σαλoμῶντος)");
        map.put("HOS", "Hos - Hosea (Ὡσηέ Αʹ)");
        map.put("AMO", "Amos - Amos (Ἀμώς Βʹ)");
        map.put("MIC", "Mic - Micah (Μιχαίας Γʹ)");
        map.put("JOE", "Joel - Joel (Ἰωήλ Δʹ)");
        map.put("OBA", "Obad - Obadiah (Ὀβδιού Εʹ)");
        map.put("JON", "Jonah - Jonah (Ἰωνᾶς Ϛ')");
        map.put("NAH", "Nah - Nahum (Ναούμ Ζʹ)");
        map.put("HAB", "Hab - Habbakuk (Ἀμβακούμ Ηʹ)");
        map.put("ZEP", "Zeph - Zephaniah (Σοφονίας Θʹ)");
        map.put("HAG", "Hag - Haggai (Ἀγγαῖος Ιʹ)");
        map.put("ZEC", "Zech - Zechariah (Ζαχαρίας ΙΑʹ)");
        map.put("MAL", "Mal - Malachi (Μαλαχίας ΙΒʹ)");
        map.put("ISA", "Isa - Isaiah (Ἠσαΐας)");
        map.put("JER", "Jer - Jeremiah (Ἱερεμίας)");
        map.put("BAR", "Bar - Baruch (Βαρούχ)");
        map.put("LAM", "Lam - Lamentations (Θρῆνοι)");
        map.put("LJE", "Ep Jer - Epistle of Jeremiah (Ἐπιστολὴ Ἰερεμίου)");
        map.put("EZE", "Ezek - Ezekiel (Ἰεζεκιήλ)");
        map.put("DAN", "Dan - Daniel (Δανιήλ)");
        map.put("MA4", "4 Macc - 4 Maccabees (Μακκαβαίων Δ' Παράρτημα)");
        map.put("STY", "Sg Three - Song of Three Youths (Οι Άγιοι Τρεις Παίδες)");
        map.put("SUS", "Sus - Susanna (Σουσάννα)");
        map.put("BEL", "Bel - Bel and the Dragon (Βὴλ καὶ Δράκων)");
        map.put("NT", "NT - New Testament (H KAINH DIAθHKH)");
        map.put("Gospel", "Gospels (ΕΥΑΓΓΕΛΙΟΝ)");
        map.put("Apostle", "Apostle (ὁ Ἀπόστολος)");
        map.put("MAT", "Matt - Matthew (Κατά Ματθαίον Ευαγγέλιον)");
        map.put("MAR", "Mark - Mark (Κατά Μάρκον Ευαγγέλιον)");
        map.put("LUK", "Luke - Luke (Κατά Λουκάν Ευαγγέλιον)");
        map.put("JOH", "John - John (Κατά Ιωάννην Ευαγγέλιον)");
        map.put("ACT", "Acts - Acts (Πράξεις των Αποστόλων)");
        map.put("ROM", "Rom - Romans (Επιστολή προς Ρωμαίους)");
        map.put("CO1", "1 Cor - 1 Corinthians (Επιστολή προς Κορινθίους Α΄)");
        map.put("CO2", "2 Cor - 2 Corinthians (Επιστολή προς Κορινθίους Β΄)");
        map.put("GAL", "Gal - Galatians (Επιστολή προς Γαλάτες)");
        map.put("EPH", "Eph - Ephesians (Επιστολή προς Εφεσίους)");
        map.put("PHP", "Phil - Philippians (Επιστολή προς Φιλιππησίους)");
        map.put("COL", "Col - Colossians (Επιστολή προς Κολοσσαείς)");
        map.put("TH1", "1 Thess - 1 Thessalonians (Επιστολή προς Θεσσαλονικείς Α΄)");
        map.put("TH2", "2 Thess - 2 Thessalonians (Επιστολή προς Θεσσαλονικείς Β΄)");
        map.put("TI1", "1 Tim - 1 Timothy (Επιστολή προς Τιμόθεο Α΄)");
        map.put("TI2", "2 Tim - 2 Timothy (Επιστολή προς Τιμόθεο Β΄)");
        map.put("TIT", "Titus - Titus (Επιστολή προς Τίτο)");
        map.put("PHM", "Phlm - Philemon (Επιστολή προς Φιλήμονα)");
        map.put("HEB", "Heb - Hebrews (Επιστολή προς Εβραίους)");
        map.put("JAM", "Jas - James (Επιστολή Ιακώβου)");
        map.put("PE1", "1 Pet - 1 Peter (Επιστολή Πέτρου Α΄)");
        map.put("PE2", "2 Pet - 2 Peter (Επιστολή Πέτρου Β΄)");
        map.put("JO1", "1 John - 1 John (Επιστολή Ιωάννη Α΄)");
        map.put("JO2", "2 John - 2 John (Επιστολή Ιωάννη Β΄)");
        map.put("JO3", "3 John - 3 John (Επιστολή Ιωάννη Γ΄)");
        map.put("JDE", "Jude - Jude (Επιστολή Ιούδα)");
        map.put("REV", "Rev - Revelation (Αποκάλυψη του Ιωάννη)");
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
    
    /**
     * Convenience method for when you don't want to bother to
     * see if the key exists in the map.
     * 
     * If it does not, the label will be set to the value of the key.
     * If it does exist, the label will have the value from the map.
     * @param key to search for
     * @return the label for that key
     */
    public static String getLabel(String key) {
    	if (map.containsKey(key)) {
    		return get(key);
    	} else {
    		return key;
    	}
    }

    /**
     * Converts the map to a JsonArray containing
     * dropdown items to use in a user interface.
     * A map key becomes the dropdown value
     * and a map value becomes the dropdown label.
     * @return dropdown items as a JsonArray
     */
    public static JsonArray toDropdownJsonArray() {
    	JsonArray array = new JsonArray();
    	for (Entry<String,String> entry : map.entrySet()) {
    		array.add(new DropdownItem(entry.getValue(), entry.getKey()).toJsonObject());
    	}
    	return array;
    }

    /**
     * Converts the map to a JsonArray containing
     * dropdown items to use in a user interface.
     * A map key becomes the dropdown value
     * and a map value becomes the dropdown label.
     * @return DropdownItems as a list
     */
    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (Entry<String,String> entry : map.entrySet()) {
    		result.add(new DropdownItem(entry.getValue(), entry.getKey()));
    	}
    	return result;
    }
    
    public static void main(String [] args) {
    	for (String key : BIBLICAL_BOOKS.map.keySet()) {
    		System.out.println("\t\t, " + key);
    	}
    }

}
