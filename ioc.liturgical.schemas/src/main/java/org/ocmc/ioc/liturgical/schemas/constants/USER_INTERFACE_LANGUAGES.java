package org.ocmc.ioc.liturgical.schemas.constants;

public enum USER_INTERFACE_LANGUAGES {
	ENGLISH("en", "English (Αγγλικά).")
	, GREEK_MODERN("el", "Greek (Ελληνικά )")
	;
	public String topic;
	public String description;
	
	private USER_INTERFACE_LANGUAGES(
			String topic
			, String description
			) {
		this.topic = topic;
		this.description = description;
	}
	
}
