package org.ocmc.ioc.liturgical.schemas.constants;

public enum GENDERS {
	male("male")
	, female("female")
	, unknown("unknown")
	;

	public String keyname = "";
	
	private GENDERS(
			String keyname
			) {
		this.keyname = keyname;
	}
		
}
