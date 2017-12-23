package org.ocmc.ioc.liturgical.schemas.models.synch;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;
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

	@Attributes(readonly = true, required = false, description = "Name of the Github account")
	@Expose public String account = "";

	@Attributes(readonly = true, required = false, description = "Name of the Repository")
	@Expose public String name = "";

	@Attributes(required = true, description = "URL to clone the Repository")
	@Expose public String url = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last synch")
	@Expose public String lastGitToDbSynchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID used for the last synch GitToDb")
	@Expose public String lastGitToDbSynchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last fetch from remote repo for GitToDb")
	@Expose public String lastGitToDbFetchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID from last fetch from remote repo for GitToDb")
	@Expose public String lastGitToDbFetchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last synch DbToGit")
	@Expose public String lastDbToGitSynchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID used for the last synch  DbToGit")
	@Expose public String lastDbToGitSynchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Timestamp of last fetch from remote repo for DbToGit")
	@Expose public String lastDbToGitFetchTime = "";
	
	@Attributes(readonly = true, required = false, description = "Commit ID from last fetch from remote repo for DbToGit")
	@Expose public String lastDbToGitFetchCommitId = "";

	@Attributes(readonly = true, required = false, description = "Last local repo path that was used for the clone or fetch")
	@Expose public String localRepoPath = "";

	public GithubRepo(
			String account
			, String name
			)  {
		super(
				Constants.LIBRARY_SYNCH
				, Constants.GITHUB
				, account + "/" + name
				, schema
				, version
				);
		this.setPrettyPrint(false);
		this.account = account;
		this.name = name;
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

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getLastGitToDbSynchTime() {
		return lastGitToDbSynchTime;
	}

	public void setLastGitToDbSynchTime(String lastGitToDbSynchTime) {
		this.lastGitToDbSynchTime = lastGitToDbSynchTime;
	}

	public String getLastGitToDbSynchCommitId() {
		return lastGitToDbSynchCommitId;
	}

	public void setLastGitToDbSynchCommitId(String lastGitToDbSynchCommitId) {
		this.lastGitToDbSynchCommitId = lastGitToDbSynchCommitId;
	}

	public String getLastGitToDbFetchTime() {
		return lastGitToDbFetchTime;
	}

	public void setLastGitToDbFetchTime(String lastGitToDbFetchTime) {
		this.lastGitToDbFetchTime = lastGitToDbFetchTime;
	}

	public String getLastGitToDbFetchCommitId() {
		return lastGitToDbFetchCommitId;
	}

	public void setLastGitToDbFetchCommitId(String lastGitToDbFetchCommitId) {
		this.lastGitToDbFetchCommitId = lastGitToDbFetchCommitId;
	}

	public String getLocalRepoPath() {
		return localRepoPath;
	}

	public void setLocalRepoPath(String localRepoPath) {
		this.localRepoPath = localRepoPath;
	}

	public String getLastDbToGitSynchTime() {
		return lastDbToGitSynchTime;
	}

	public void setLastDbToGitSynchTime(String lastDbToGitSynchTime) {
		this.lastDbToGitSynchTime = lastDbToGitSynchTime;
	}

	public String getLastDbToGitSynchCommitId() {
		return lastDbToGitSynchCommitId;
	}

	public void setLastDbToGitSynchCommitId(String lastDbToGitSynchCommitId) {
		this.lastDbToGitSynchCommitId = lastDbToGitSynchCommitId;
	}

	public String getLastDbToGitFetchTime() {
		return lastDbToGitFetchTime;
	}

	public void setLastDbToGitFetchTime(String lastDbToGitFetchTime) {
		this.lastDbToGitFetchTime = lastDbToGitFetchTime;
	}

	public String getLastDbToGitFetchCommitId() {
		return lastDbToGitFetchCommitId;
	}

	public void setLastDbToGitFetchCommitId(String lastDbToGitFetchCommitId) {
		this.lastDbToGitFetchCommitId = lastDbToGitFetchCommitId;
	}

}
