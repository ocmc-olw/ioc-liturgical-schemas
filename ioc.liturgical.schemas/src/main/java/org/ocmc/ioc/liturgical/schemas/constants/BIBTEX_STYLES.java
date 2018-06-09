package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum BIBTEX_STYLES {
    ALPHABETIC("alphabetic","Alphabetic"),
    ALPHABETIC_VERB("alphabetic-verb","Alphabetic, verbose"),
    AUTHOR_TITLE("authortitle","Author, Title"),
    AUTHOR_TITLE_COMP("authortitle-comp","Author, title, compact"),
    AUTHOR_TITLE_IBID("authortitle-ibid","Author, title, Ibid"),
    AUTHOR_TITLE_ICOMP("authortitle-icomp","Combines author, year, compact  with author, year, ibid"),
    AUTHOR_TITLE_TCOMP("authortitle-tcomp","Combines author, title, compact with author, title, terse"),
    AUTHOR_TITLE_TERSE("authortitle-terse","Author, title, terse"),
    AUTHOR_TITLE_TICOMP ("authortitle-ticomp","Combines author, title, icomp with author, title, terse"),
    AUTHOR_YEAR ("authoryear","Author, year"),
    AUTHOR_YEAR_COMP("authoryear-comp","Author, year, compact"),
    AUTHOR_YEAR_IBID("authoryear-ibid","Author, year, ibid"),
    AUTHOR_YEAR_ICOMP("authoryear-icomp","Combines Author, year, compact and author, year, ibid"),
    NUMERIC("numeric","Numeric"),
    NUMERIC_COMP("numeric-comp","Numeric, Compact"),
    NUMERIC_VERB("numeric-verb","Numeric, Verbose"),
    READING("reading","Reading"),
    VERBOSE("verbose","Verbose"),
    VERBOSE_IBID("verbose-ibid","Verbose, ibid"),
    VERBOSE_INOTE("verbose-inote","Verbose, ibid using ibidem"),
    VERBOSE_NOTE("verbose-note","Verbose first time, shorter afterward"),
    VERBOSE__TRAD1("verbose-trad1","Verbose, traditional version 1"),
    VERBOSE__TRAD2("verbose-trad2","Verbose, traditional version 2"),
    VERBOSE_TRAD3("verbose-trad3","Verbose, traditional version 3")
	;

	public String keyname = "";
	public String title = "";
	
	private BIBTEX_STYLES(
			String keyname
			, String title
			) {
		this.title = title;
		this.keyname = keyname;
	}
		
	public static BIBTEX_STYLES getEnumForKeyname(String keyname) {
    	for (BIBTEX_STYLES e : BIBTEX_STYLES.values()) {
    		if (e.keyname.equals(keyname)) {
    			return e;
    		}
    	}
    	return null;
	}
    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (BIBTEX_STYLES e : BIBTEX_STYLES.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.title, e.keyname).toJsonObject());
    	}
    	return result;
    }

}
