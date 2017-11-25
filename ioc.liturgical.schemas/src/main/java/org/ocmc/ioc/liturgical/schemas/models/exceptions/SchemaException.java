package org.ocmc.ioc.liturgical.schemas.models.exceptions;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

/**
 * {"pointerToViolation":"#/username","causingExceptions":[],"keyword":"minLength","message":"expected minLength: 3, actual: 0"}
 * @author mac002
 *
 */
public class SchemaException extends AbstractModel {
	@Expose public String pointerToViolation = "";
	@Expose public String [] causingExceptions = new String[0];
	@Expose public String keyword = "";
	@Expose public String message = "";
	
	public SchemaException () {
		super();
	}
	
	/**
	 * Records an exception to a schema
	 * @param pointerToViolation index of the violation
	 * @param keyword the keyword
	 * @param message the message
	 */
	public SchemaException(String pointerToViolation, String keyword, String message) {
		this.pointerToViolation = pointerToViolation;
		this.keyword = keyword;
		this.message = message;
	}

	/**
	 * Get the index pointer to where the violation occurs
	 * @return the index pointer to where the violation occurs
	 */
	public String getPointerToViolation() {
		return pointerToViolation;
	}

	/**
	 * Set the pointer index to where the violation occurs
	 * @param pointerToViolation pointer to the violation
	 */
	public void setPointerToViolation(String pointerToViolation) {
		this.pointerToViolation = pointerToViolation;
	}

	/**
	 * Get the things causing the exceptions
	 * @return an array of the exception causes
	 */
	public String[] getCausingExceptions() {
		return causingExceptions;
	}

	/**
	 * Set the things causing the exceptions
	 * @param causingExceptions that which is causing the exceptions
	 */
	public void setCausingExceptions(String[] causingExceptions) {
		this.causingExceptions = causingExceptions;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
