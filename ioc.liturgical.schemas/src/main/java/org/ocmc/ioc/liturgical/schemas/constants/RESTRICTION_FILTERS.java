package org.ocmc.ioc.liturgical.schemas.constants;

public enum RESTRICTION_FILTERS {
	WS_ADMIN("web service administrator")
	, ALL_DOMAINS_ADMIN("all-domains administrator")
	, ALL_DOMAINS_AUTHOR("all-domains author")
	, ALL_DOMAINS_READER("all-domains reader")
	, ALL_DOMAINS_REVIEWER("all-domains reviewer")
	, DOMAIN_ADMIN("domain administrator")
	, DOMAIN_AUTHOR("domain author")
	, DOMAIN_READER("domain reader")
	, DOMAIN_REVIEWER("domain reviewer")
	, NONE("unrestricted")
	;

	public String keyname = "";
	
	private RESTRICTION_FILTERS(
			String keyname
			) {
		this.keyname = keyname;
	}
		
}
