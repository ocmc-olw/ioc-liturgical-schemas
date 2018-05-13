package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum BIBTEX_ENTRY_TYPES {
	ARTICLE("article", "Articles")
	, BOOK("book", "Books")
	, BOOKINBOOK("bookinbook", "Book in Book")
	, BOOKLET("booklet", "Booklets")
	, COLLECTION("collection", "Collections")
	, INBOOK("inbook", "In Book")
	, INCOLLECTION("incollection", "In Collection")
	, INPROCEEDINGS("inproceedings", "In Proceedings")
	, INREFERENCE("inmvreference", "In Reference")
	, MANUAL("manual", "Manuals")
	, MISC("misc", "Miscellaneous")
	, MVBOOK("mvbook", "Muti-Volume Books")
	, MVCOLLECTION("mvcollection", "Multi-Volume Collections")
	, MVPROCEEDINGS("mvproceedings", "Multi-Volume Proceedings")
	, MVREFERENCE("mvreference", "Multi-Volume References")
	, ONLINE("online", "Online Resources")
	, PATENT("patent", "Patents")
	, PERIODICAL("periodical", "Periodicals")
	, PROCEEDINGS("proceedings", "Proceedings")
	, REFERENCE("reference", "References")
	, REPORT("report", "Reports")
	, SUPPBOOK("suppbook", "Book Supplements")
	, SUPPCOLLECTION("supcollection", "Collection Supplementals")
	, SUPPPERIODICAL("supperiodical", "Periodical Supplements")
	, THESIS("thesis", "Theses")
	, UNPUBLISHED("unpublished", "Unpublished")
	;

	public String keyname = "";
	public String title = "";
	
	private BIBTEX_ENTRY_TYPES(
			String keyname
			, String title
			) {
		this.title = title;
		this.keyname = keyname;
	}
		
	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @param includeAny if true will add to the top an object that is value=*, label=any
	 * @return a JsonArray of Dropdowns 
	 */
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (BIBTEX_ENTRY_TYPES e : BIBTEX_ENTRY_TYPES.values()) {
    		result.add(new DropdownItem(e.title).toJsonObject());
    	}
    	return result;
    }

}
