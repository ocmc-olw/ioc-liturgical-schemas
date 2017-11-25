package org.ocmc.ioc.liturgical.schemas.exceptions;

/**
 * Thrown if an ID doesn't have three parts separated by
 * the ID separator.
 * @author mac002
 *
 */
public class BadIdException extends Exception {
	
	/**
	 * Exception for an ID not being formatted correctly.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message to be reported for the exception
	 */
	public BadIdException(String message) {
        super(message);
    }

	/**
	 * 
	 * @param message to be reported for the exception
	 * @param throwable true if throwable
	 */
    public BadIdException(String message, Throwable throwable) {
        super(message, throwable);
    }

}