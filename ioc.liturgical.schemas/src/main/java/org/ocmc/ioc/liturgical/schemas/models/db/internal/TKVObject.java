package org.ocmc.ioc.liturgical.schemas.models.db.internal;

public class TKVObject extends TKVString {
	public TKVObject() {
		super();
	}
	
	public String getValue() {
		return this.toJsonString();
	}
	
	public void setValue() {
		super.setValue(this.getValue());
	}

}
