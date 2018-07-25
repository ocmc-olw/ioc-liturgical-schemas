package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import java.util.Map;
import java.util.TreeMap;

import org.ocmc.ioc.liturgical.utils.GeneralUtils;

/**
 * Maps punctuation marks and words to their dependency tree label
 * if possible to do so out of context
 * 
 * @author mac002
 *
 */
public class UD_DEPENDENCY_LABEL_MAPPER {
    private static Map<String, UD_DEPENDENCY_LABELS> map = new TreeMap<String,UD_DEPENDENCY_LABELS>();
    static {
    	// punctuation
    	map.put(".",UD_DEPENDENCY_LABELS.CONJ);
    	map.put(",",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put("˙",UD_DEPENDENCY_LABELS.PUNCT); // greek colon
    	map.put("·",UD_DEPENDENCY_LABELS.PUNCT); // greek colon (alternate version)
    	map.put(";",UD_DEPENDENCY_LABELS.PUNCT); // greek question mark
    	map.put("?",UD_DEPENDENCY_LABELS.PUNCT); 
    	map.put("\"",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put("'",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put(":",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put("`",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put("!",UD_DEPENDENCY_LABELS.PUNCT);
    	map.put("(", UD_DEPENDENCY_LABELS.PUNCT);
    	map.put(")", UD_DEPENDENCY_LABELS.PUNCT);
    	// conjunctions
    	map.put("και", UD_DEPENDENCY_LABELS.CC);
    	map.put("οτι", UD_DEPENDENCY_LABELS.MARK);
    	map.put("ἀλλ'",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἀλλά",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἄν",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἄρ",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἄρ'",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἄρα",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἀτάρ",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("αὐτάρ",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἄχρι",UD_DEPENDENCY_LABELS.CASE);
    	map.put("γάρ",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("δ'",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("δέ",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("διό",UD_DEPENDENCY_LABELS.MARK);
    	map.put("διότι",UD_DEPENDENCY_LABELS.MARK);
    	map.put("ἐάν",UD_DEPENDENCY_LABELS.MARK);
    	map.put("εἰ",UD_DEPENDENCY_LABELS.MARK);
    	map.put("εἴ",UD_DEPENDENCY_LABELS.MARK);
    	map.put("εἰκ",UD_DEPENDENCY_LABELS.USP);
    	map.put("εἵνεκα",UD_DEPENDENCY_LABELS.CASE);
    	map.put("εἷος",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("εἴπερ",UD_DEPENDENCY_LABELS.MARK);
    	map.put("εἴτε",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἕνεκα",UD_DEPENDENCY_LABELS.CASE);
    	map.put("ἐπεί",UD_DEPENDENCY_LABELS.MARK);
    	map.put("ἐπειδή",UD_DEPENDENCY_LABELS.MARK);
    	map.put("ἐπήν",UD_DEPENDENCY_LABELS.ADVMOD);
    	map.put("ἕως",UD_DEPENDENCY_LABELS.MARK);
    	map.put("ἢ",UD_DEPENDENCY_LABELS.CC);
    	map.put("ἤ",UD_DEPENDENCY_LABELS.CC);
    	map.put("ἠδ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἠδέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἠέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἦε",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἠμέν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἤν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἤτοι",UD_DEPENDENCY_LABELS.USP);
    	map.put("θ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἰδέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἵν'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ἵνα",UD_DEPENDENCY_LABELS.USP);
    	map.put("καί",UD_DEPENDENCY_LABELS.USP);
    	map.put("καίπερ",UD_DEPENDENCY_LABELS.USP);
    	map.put("κᾷτα",UD_DEPENDENCY_LABELS.USP);
    	map.put("μέχρι",UD_DEPENDENCY_LABELS.USP);
    	map.put("μέχρις",UD_DEPENDENCY_LABELS.USP);
    	map.put("μηδ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("μηδέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("μήποτε",UD_DEPENDENCY_LABELS.USP);
    	map.put("μήτε",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὁπότ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὁπόταν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὅπως",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὅταν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὅτι",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὅττι",UD_DEPENDENCY_LABELS.USP);
    	map.put("οὐδ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("οὐδέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("οὐκοῦν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὄφρ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὄφρα",UD_DEPENDENCY_LABELS.USP);
    	map.put("πάρος",UD_DEPENDENCY_LABELS.USP);
    	map.put("πλήν",UD_DEPENDENCY_LABELS.USP);
    	map.put("πρίν",UD_DEPENDENCY_LABELS.USP);
    	map.put("ῥ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("ῥά",UD_DEPENDENCY_LABELS.USP);
    	map.put("ῥα",UD_DEPENDENCY_LABELS.USP);
    	map.put("τ'",UD_DEPENDENCY_LABELS.USP);
    	map.put("τέ",UD_DEPENDENCY_LABELS.USP);
    	map.put("τε",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὡς",UD_DEPENDENCY_LABELS.USP);
    	map.put("ὥστε",UD_DEPENDENCY_LABELS.USP);    	// prepositions
    	map.put("αμφι", UD_DEPENDENCY_LABELS.CASE);
    	map.put("ανα", UD_DEPENDENCY_LABELS.CASE);
    	map.put("αντι", UD_DEPENDENCY_LABELS.CASE);
    	map.put("απο", UD_DEPENDENCY_LABELS.CASE);
    	map.put("δια", UD_DEPENDENCY_LABELS.CASE);
    	map.put("εις", UD_DEPENDENCY_LABELS.CASE);
    	map.put("ες", UD_DEPENDENCY_LABELS.CASE);
       	map.put("εν", UD_DEPENDENCY_LABELS.CASE);
    	map.put("εξ", UD_DEPENDENCY_LABELS.CASE);
    	map.put("εκ", UD_DEPENDENCY_LABELS.CASE);
    	map.put("επι", UD_DEPENDENCY_LABELS.CASE);
    	map.put("κατα", UD_DEPENDENCY_LABELS.CASE);
    	map.put("μετα", UD_DEPENDENCY_LABELS.CASE);
    	map.put("παρα", UD_DEPENDENCY_LABELS.CASE);
    	map.put("περι", UD_DEPENDENCY_LABELS.CASE);
    	map.put("προ", UD_DEPENDENCY_LABELS.CASE);
    	map.put("προς", UD_DEPENDENCY_LABELS.CASE);
    	map.put("συν", UD_DEPENDENCY_LABELS.CASE);
    	map.put("υπερ", UD_DEPENDENCY_LABELS.CASE);
    	map.put("υπο", UD_DEPENDENCY_LABELS.CASE);
       // definite articles
        map.put("ο", UD_DEPENDENCY_LABELS.DET);
        map.put("του", UD_DEPENDENCY_LABELS.DET);
        map.put("τω", UD_DEPENDENCY_LABELS.DET);
        map.put("τον", UD_DEPENDENCY_LABELS.DET);
        map.put("ω", UD_DEPENDENCY_LABELS.DET);
        map.put("οι", UD_DEPENDENCY_LABELS.DET);
        map.put("των", UD_DEPENDENCY_LABELS.DET);
        map.put("τοις", UD_DEPENDENCY_LABELS.DET);
        map.put("τους", UD_DEPENDENCY_LABELS.DET);
        map.put("η", UD_DEPENDENCY_LABELS.DET);
        map.put("της", UD_DEPENDENCY_LABELS.DET);
        map.put("τη", UD_DEPENDENCY_LABELS.DET);
        map.put("την", UD_DEPENDENCY_LABELS.DET);
        map.put("τις", UD_DEPENDENCY_LABELS.DET);
        map.put("το", UD_DEPENDENCY_LABELS.DET);
        map.put("τα", UD_DEPENDENCY_LABELS.DET);
	}


    /**
     * Get the dependency label for this punctuation mark
     * @param s key to search for
     * @return label for that key
     */
    public static UD_DEPENDENCY_LABELS getLabel(String s) {
    	String n = GeneralUtils.normalize(s);
    	if (map.containsKey(n)) {
    		return map.get(n);
    	} else {
    		if (s.equals("·")) {
    			return UD_DEPENDENCY_LABELS.PUNCT;
    		} else {
        		return UD_DEPENDENCY_LABELS.USP;
    		}
    	}
    }
    
    public static boolean isPunctuation(String s) {
    	boolean result = false;
    	if (s.equals("·")) {
    		System.out.print("");
    	}
    	String n = GeneralUtils.normalize(s);
    	UD_DEPENDENCY_LABELS label = getLabel(n);
    	result = n.length() == 1
    			&& (
    					label.equals(UD_DEPENDENCY_LABELS.PUNCT)
    			)
		;
    	return result;
    }
}
