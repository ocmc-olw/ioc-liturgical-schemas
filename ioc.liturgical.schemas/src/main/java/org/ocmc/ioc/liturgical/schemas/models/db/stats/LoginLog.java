package org.ocmc.ioc.liturgical.schemas.models.db.stats;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

/**
 * Records the number of times login has occurred, and the last time one occurred.
 * @author mac002
 *
 */
public class LoginLog extends LTKLite {
	private static String schema = LoginLog.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose  public String lastTimestamp = "2000-01-01T12:00:23.764Z";
	@Expose  public long count;
	
	public LoginLog() {
		super(
				Constants.LIBRARY_LOGIN
				, Constants.TOPIC_STATS
				, Constants.KEY_LOG
				, schema
				, version
				);		
	}

	public String getLastTimestamp() {
		return lastTimestamp;
	}

	public void setLastTimestamp(String lastTimestamp) {
		this.lastTimestamp = lastTimestamp;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

}
