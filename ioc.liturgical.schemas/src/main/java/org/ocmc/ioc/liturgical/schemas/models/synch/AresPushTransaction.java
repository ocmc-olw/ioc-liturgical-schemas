package org.ocmc.ioc.liturgical.schemas.models.synch;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.exceptions.BadIdException;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.annotations.Expose;

/**
 * Provides a model for transactions pushed from synchronization of an ares file.  
 * An ares file is an ALWB library file. 
 * 
 * The database should have a constraint on n:AresTransaction property timestamp.
 * 
 * @author mac002
 *
 */
public class AresPushTransaction extends LTKLite {
	private static String schema = AresPushTransaction.class.getSimpleName();
	private static double version = 1.1;
	
	public enum TYPES {
		ADD_KEY_VALUE
		, CHANGE_OF_KEY
		, CHANGE_OF_LIBRARY // ares file rename of library part
		, CHANGE_OF_TOPIC // ares file rename of topic part
		, CHANGE_OF_VALUE
		, DELETE_KEY_VALUE
		, DELETE_TOPIC // ares file deleted
		, UNKNOWN
	}

	@Expose public TYPES type = TYPES.UNKNOWN; 
	@Expose public String whenTransactionRecordedInThisDatabase = "";
	@Expose public String requestingServer = "";
	@Expose public String requestingMac = "";
	@Expose public String requestingUser = "";
	
	@Expose public String fromLibrary = "";
	@Expose public String fromTopic = "";
	@Expose public String fromKey = "";
	@Expose public String fromValue = "";
	@Expose public String fromComment = "";

	@Expose public String toLibrary = "";
	@Expose public String toTopic = "";
	@Expose public String toKey = "";
	@Expose public String toValue = "";
	@Expose public String toComment = "";

	public AresPushTransaction(
			String requestingServer
			, String requestingMac
			, String timestamp
			) throws BadIdException {
		super(
				Constants.LIBRARY_SYNCH
				, requestingServer + requestingMac
				, timestamp
				, schema
				, version
				);
		this.setPrettyPrint(false);
		this.whenTransactionRecordedInThisDatabase = Instant.now().toString();
		this.requestingServer = requestingServer;
		this.requestingMac = requestingMac;
	}

	public String getRequestingServer() {
		return requestingServer;
	}

	public void setRequestingServer(String requestingServer) {
		this.requestingServer = requestingServer;
	}

	/**
	 * The most important timestamp is the one obtained by AresPushTransaction.getKey().
	 * It is the timestamp for when the original record was saved to the requesting local database.
	 * This method gets the timestamp for when the transaction was recorded by the SynchManager web service.
	 * The whenTransactionRecordedInThisDatabase timestamp will likely be more recent than Transaction.getKey().
	 * The usefulness of whenTransactionRecordedInThisDatabase is to determine if there was a significant
	 * time lag between the local database being updated and the synch database getting the transaction.
	 * @return the timestamp for when the transaction was recorded
	 */
	public String getWhenTransactionRecordedInThisDatabase() {
		return whenTransactionRecordedInThisDatabase;
	}

	public void setWhenTransactionRecordedInThisDatabase(String whenTransactionRecordedInThisDatabase) {
		this.whenTransactionRecordedInThisDatabase = whenTransactionRecordedInThisDatabase;
	}

	public String getRequestingMac() {
		return requestingMac;
	}

	/**
	 * Set the MAC address of the requesting machine
	 * @param requestingMac the MAC address of the requesting machine
	 */
	public void setRequestingMac(String requestingMac) {
		this.requestingMac = requestingMac;
	}


	public TYPES getType() {
		return type;
	}


	public void setType(TYPES type) {
		this.type = type;
	}


	public String getFromLibrary() {
		return fromLibrary;
	}


	public void setFromLibrary(String fromLibrary) {
		this.fromLibrary = fromLibrary;
	}


	public String getFromTopic() {
		return fromTopic;
	}


	public void setFromTopic(String fromTopic) {
		this.fromTopic = fromTopic;
	}


	public String getFromKey() {
		return fromKey;
	}


	public void setFromKey(String fromKey) {
		this.fromKey = fromKey;
	}


	public String getFromValue() {
		return fromValue;
	}


	public void setFromValue(String fromValue) {
		this.fromValue = fromValue;
	}


	public String getFromComment() {
		return fromComment;
	}


	public void setFromComment(String fromComment) {
		this.fromComment = fromComment;
	}


	public String getToLibrary() {
		return toLibrary;
	}


	public void setToLibrary(String toLibrary) {
		this.toLibrary = toLibrary;
	}


	public String getToTopic() {
		return toTopic;
	}


	public void setToTopic(String toTopic) {
		this.toTopic = toTopic;
	}


	public String getToKey() {
		return toKey;
	}


	public void setToKey(String toKey) {
		this.toKey = toKey;
	}


	public String getToValue() {
		return toValue;
	}


	public void setToValue(String toValue) {
		this.toValue = toValue;
	}


	public String getToComment() {
		return toComment;
	}


	public void setToComment(String toComment) {
		this.toComment = toComment;
	}

	public String getRequestingUser() {
		return requestingUser;
	}

	public void setRequestingUser(String requestingUser) {
		this.requestingUser = requestingUser;
	}

}
