package org.ocmc.ioc.liturgical.schemas.constants.nlp;

public enum DEPENDENCY_LABELS_PERSEUS {
	ADV("ADV","adverb","")
	, ADV_CO("ADV_CO","adverb - coordinated","")
	, APOS("APOS","apposing element","PM")
	, ATR("ATR","attributive","")
	, ATR_CO("ATR_CO","attributive - coordinated","")
	, ATV("ATV","complement","")
	, AuxC("AuxC","conjunction","CONJ")
	, AuxG("AuxG","bracketing punctuation","")
	, AuxK("AuxK","terminal punctuation","")
	, AuxP("AuxP","preposition","PREP")
	, AuxV("AuxV","auxiliary verb","")
	, AuxX("AuxX","comma","PM")
	, AuxY("AuxY","sentence adverbial","")
	, AuxZ("AuxZ","emphasizing particle","")
	, COORD("COORD","coordinator","CONJ")
	, ExD("ExD","ellipsis","")
	, OBJ("OBJ","object","")
	, OBJ_CO("OBJ_CO","object - coordinated","")
	, OCOMP("OCOMP","object complement","")
	, PNOM("PNOM","predicate nominal","")
	, PRED("PRED","predicate","")
	, PRED_CO("PRED_CO","predicate - coordinated","")
	, ROOT("ROOT","root of a dependency tree","")
	, SBJ("SBJ","subject","")
	, SBJ_CO("SUB_CO","adverb - coordinated","")
	, SCAN("SCAN","scansion","")
	, ST("ST","sub-tree","")
	, TBD("TBD","to-be-determined","tbd")
	;
	public String keyname = "";
	public String description = "";
	public String parse = "";
	
	private DEPENDENCY_LABELS_PERSEUS(
			String keyname
			, String description
			, String parse
			) {
		this.keyname = keyname;
		this.description = description;
		this.parse = parse;
	}
		
	/**
	 * Find the Enum value for this keyname
	 * @param name to search for
	 * @return Entry the enum for that name
	 */
	public static DEPENDENCY_LABELS_PERSEUS forName(String name) {
		for (DEPENDENCY_LABELS_PERSEUS v : DEPENDENCY_LABELS_PERSEUS.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return DEPENDENCY_LABELS_PERSEUS.TBD;
	}
}
