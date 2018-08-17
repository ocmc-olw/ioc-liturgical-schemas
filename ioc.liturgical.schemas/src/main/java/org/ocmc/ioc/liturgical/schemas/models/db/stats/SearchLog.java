package org.ocmc.ioc.liturgical.schemas.models.db.stats;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

/**
 * Records the number of times a text search has been done, and the last time one occurred.
 * @author mac002
 *
 */
public class SearchLog extends LTKLite {
	private static String schema = SearchLog.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose  public String lastSearchedTimestamp = "2000-01-01T12:00:23.764Z";
	@Expose  public long searchCount;
	
	public SearchLog() {
		super(
				Constants.LIBRARY_SEARCH
				, Constants.TOPIC_STATS
				, Constants.KEY_LOG
				, schema
				, version
				);		
	}

	public String getLastSearchedTimestamp() {
		return lastSearchedTimestamp;
	}

	public void setLastSearchedTimestamp(String lastSearchedTimestamp) {
		this.lastSearchedTimestamp = lastSearchedTimestamp;
	}

	public long getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(long searchCount) {
		this.searchCount = searchCount;
	}

}
