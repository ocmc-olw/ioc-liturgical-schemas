package org.ocmc.ioc.liturgical.schemas.models.messaging;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;
import org.ocmc.ioc.liturgical.schemas.models.synch.Transaction;

import com.google.gson.annotations.Expose;

public class Message extends LTKLite {
	
	private static String schema = Message.class.getSimpleName();
	private static double version = 1.1;

	@Expose public String message = null;

	public Message (
			String digest
			, String message
			) {
		super(
				Constants.LIBRARY_MESSAGES
				,Constants.TOPIC_MESSAGES
				, digest
				, schema
				, version
				);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
