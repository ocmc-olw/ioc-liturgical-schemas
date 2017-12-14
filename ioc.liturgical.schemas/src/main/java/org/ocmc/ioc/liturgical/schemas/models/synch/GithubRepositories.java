package org.ocmc.ioc.liturgical.schemas.models.synch;


import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * Contains a list of the repositories to be synched from Github
 * 
 * @author mac002
 *
 */
public class GithubRepositories extends LTKLite {
	private static String schema = GithubRepositories.class.getSimpleName();
	private static double version = 1.1;

	@Attributes(readonly = true, required = false, description = "Name of the Repository")
	@Expose List<GithubRepo> repos = new ArrayList<GithubRepo>();
	
	public GithubRepositories(
			)  {
		super(
				Constants.LIBRARY_SYNCH
				, Constants.GITHUB
				, Constants.REPOS
				, schema
				, version
				);
		this.setPrettyPrint(false);
	}

	public List<GithubRepo> getRepos() {
		return repos;
	}

	public void setRepos(List<GithubRepo> repos) {
		this.repos = repos;
	}
	
	public void addRepo(GithubRepo repo) {
		if (! this.repos.contains(repo)) {
			this.repos.add(repo);
		}
	}
	
	public void removeRepo(GithubRepo repo) {
		if (this.repos.contains(repo)) {
			this.repos.remove(repo);
		}
	}

}
