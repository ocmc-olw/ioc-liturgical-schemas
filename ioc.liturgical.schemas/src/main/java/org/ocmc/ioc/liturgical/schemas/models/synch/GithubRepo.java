package org.ocmc.ioc.liturgical.schemas.models.synch;


import org.apache.commons.io.FilenameUtils;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * Provides a model for recording information about a Github Repo
 * that will be synched
 * 
 * @author mac002
 *
 */
public class GithubRepo extends LTKLite {
	private static final Logger logger = LoggerFactory.getLogger(GithubRepo.class);
	private static String schema = GithubRepo.class.getSimpleName();
	private static double version = 1.1;

	@Attributes(readonly = true, required = false, description = "Name of the Repository")
	@Expose public String name = "";

	@Attributes(required = true, description = "URL to clone the Repository")
	@Expose public String url = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last synch")
	@Expose public String lastSynchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID used for the last synch")
	@Expose public String lastSynchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last fetch from remote repo")
	@Expose public String lastFetchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID from last fetch from remote repo")
	@Expose public String lastFetchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Last local repo path that was used for the clone or fetch")
	@Expose public String lastFetchLocalPath = "";

	public GithubRepo(
			String url
			)  {
		super(
				Constants.LIBRARY_SYNCH
				, Constants.GITHUB
				, urlToName(url)
				, schema
				, version
				);
		this.setPrettyPrint(false);
		this.url = url;
		this.name = this.key;
	}

	private static String urlToName(String url) {
		String result = url;
		try {
			result = FilenameUtils.getName(url);
			if (result.endsWith(".git")) {
				result = result.substring(0, result.length()-4);
			}
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return result;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getLastSynchTime() {
		return lastSynchTime;
	}

	public void setLastSynchTime(String lastSynchTime) {
		this.lastSynchTime = lastSynchTime;
	}

	public String getLastSynchCommitId() {
		return lastSynchCommitId;
	}

	public void setLastSynchCommitId(String lastSynchCommitId) {
		this.lastSynchCommitId = lastSynchCommitId;
	}

	public String getLastFetchTime() {
		return lastFetchTime;
	}

	public void setLastFetchTime(String lastFetchTime) {
		this.lastFetchTime = lastFetchTime;
	}

	public String getLastFetchCommitId() {
		return lastFetchCommitId;
	}

	public void setLastFetchCommitId(String lastFetchCommitId) {
		this.lastFetchCommitId = lastFetchCommitId;
	}

	public String getLastFetchLocalPath() {
		return lastFetchLocalPath;
	}

	public void setLastFetchLocalPath(String lastFetchLocalPath) {
		this.lastFetchLocalPath = lastFetchLocalPath;
	}

}
