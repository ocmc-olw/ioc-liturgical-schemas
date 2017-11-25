package org.ocmc.ioc.liturgical.schemas.models.exceptions;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

/**
 * Holds information about a schema exception
 * @author mac002
 *
 */
public class SchemaExceptionDescription extends AbstractModel {
	@Expose public String keyword;
	@Expose public String field;
	@Expose public String expected;
	@Expose public String got;
	
	public SchemaExceptionDescription(
			String keyword
			, String field
			, String expected
			, String got
			) {
		super();
		this.keyword = keyword;
		this.field = field;
		this.expected = expected;
		this.got = got;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getExpected() {
		return expected;
	}

	public void setExpected(String expected) {
		this.expected = expected;
	}

	public String getGot() {
		return got;
	}

	public void setGot(String got) {
		this.got = got;
	}
	
	public String toString() {
		return "expected " + field + " " + keyword + ":" + " " + got; 
	}
}

