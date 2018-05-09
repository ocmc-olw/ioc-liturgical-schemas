package org.ocmc.ioc.liturgical.schemas.constants;

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
	
	private BIBTEX_ENTRY_TYPES(
			String keyname
			, String title
			) {
		this.keyname = keyname;
	}
		
}
