package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import java.util.Map;
import java.util.TreeMap;

import org.ocmc.ioc.liturgical.utils.GeneralUtils;

/**
 * Maps punctuation marks and words to their dependency tree label
 * if possible to do so out of context
 * 
 * <p><a href="https://ufal.mff.cuni.cz/pdt2.0/doc/manuals/en/a-layer/html/ch03s02x08.html">See this reference</a>
 * @author mac002
 *
 */
public class DEPENDENCY_LABEL_MAPPER {
    private static Map<String, DEPENDENCY_LABELS_PERSEUS> map = new TreeMap<String,DEPENDENCY_LABELS_PERSEUS>();
    static {
    	// punctuation
    	map.put(".",DEPENDENCY_LABELS_PERSEUS.AuxK);
    	map.put(",",DEPENDENCY_LABELS_PERSEUS.AuxX);
    	map.put("˙",DEPENDENCY_LABELS_PERSEUS.APOS); // greek colon
    	map.put("·",DEPENDENCY_LABELS_PERSEUS.APOS); // greek colon (alternate version)
    	map.put(";",DEPENDENCY_LABELS_PERSEUS.AuxK); // greek question mark
    	map.put("?",DEPENDENCY_LABELS_PERSEUS.AuxK); 
    	map.put("\"",DEPENDENCY_LABELS_PERSEUS.AuxG);
    	map.put("'",DEPENDENCY_LABELS_PERSEUS.AuxG);
    	map.put(":",DEPENDENCY_LABELS_PERSEUS.APOS);
    	map.put("`",DEPENDENCY_LABELS_PERSEUS.AuxG);
    	map.put("!",DEPENDENCY_LABELS_PERSEUS.AuxK);
    	map.put("(", DEPENDENCY_LABELS_PERSEUS.AuxG);
    	map.put(")", DEPENDENCY_LABELS_PERSEUS.AuxG);
    	// conjunctions
    	map.put("και", DEPENDENCY_LABELS_PERSEUS.COORD);
    	map.put("οτι", DEPENDENCY_LABELS_PERSEUS.AuxC);
    	// prepositions
    	map.put("αμφι", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("ανα", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("αντι", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("απο", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("δια", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("εις", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("ες", DEPENDENCY_LABELS_PERSEUS.AuxP);
       	map.put("εν", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("εξ", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("εκ", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("επι", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("κατα", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("μετα", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("παρα", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("περι", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("προ", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("προς", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("συν", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("υπερ", DEPENDENCY_LABELS_PERSEUS.AuxP);
    	map.put("υπο", DEPENDENCY_LABELS_PERSEUS.AuxP);
       // definite articles
        map.put("ο", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("του", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τω", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τον", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("ω", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("οι", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("των", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τοις", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τους", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("η", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("της", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τη", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("την", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τις", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("το", DEPENDENCY_LABELS_PERSEUS.ATR);
        map.put("τα", DEPENDENCY_LABELS_PERSEUS.ATR);
	}


    /**
     * Get the dependency label for this punctuation mark
     * @param s key to search for
     * @return label for that key
     */
    public static DEPENDENCY_LABELS_PERSEUS getLabel(String s) {
    	String n = GeneralUtils.normalize(s);
    	if (map.containsKey(n)) {
    		return map.get(n);
    	} else {
    		if (s.equals("·")) {
    			return DEPENDENCY_LABELS_PERSEUS.APOS;
    		} else {
        		return DEPENDENCY_LABELS_PERSEUS.TBD;
    		}
    	}
    }
    
    public static boolean isPunctuation(String s) {
    	boolean result = false;
    	if (s.equals("·")) {
    		System.out.print("");
    	}
    	String n = GeneralUtils.normalize(s);
    	DEPENDENCY_LABELS_PERSEUS label = getLabel(n);
    	result = n.length() == 1
    			&& (
    					label.equals(DEPENDENCY_LABELS_PERSEUS.AuxG)
    					|| label.equals(DEPENDENCY_LABELS_PERSEUS.AuxK)
    					|| label.equals(DEPENDENCY_LABELS_PERSEUS.AuxX)
    					|| label.equals(DEPENDENCY_LABELS_PERSEUS.APOS)
    			)
		;
    	return result;
    }
}
