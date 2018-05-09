package org.ocmc.ioc.liturgical.schemas.constants;

public enum BIBTEX_SOURCE_TYPES {
	PRIMARY("primary", "Original publication, original research, manuscript, or eyewitness account")
	, SECONDARY("secondary", "Provides an analysis of a primary source.")
	, TERTIARY("tertiary", "Provides an overview of primary and/or secondary sources, without an analysis.")
	;

	public String keyname = "";
	public String description = "";
	
	private BIBTEX_SOURCE_TYPES(
			String keyname
			, String description
			) {
		this.keyname = keyname;
		this.description = description;
	}
		
}
