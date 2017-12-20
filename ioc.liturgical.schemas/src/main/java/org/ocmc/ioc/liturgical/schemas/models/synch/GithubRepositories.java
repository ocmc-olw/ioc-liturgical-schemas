package org.ocmc.ioc.liturgical.schemas.models.synch;


import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;

/**
 * Contains a list of the repositories to be synched from Github
 * 
 * @author mac002
 *
 */
public class GithubRepositories extends AbstractModel {
	private static final Logger logger = LoggerFactory.getLogger(GithubRepositories.class);

	@Expose List<GithubRepo> repos = new ArrayList<GithubRepo>();
	
	public GithubRepositories(
			)  {
		super();
		this.setPrettyPrint(false);
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

	public List<GithubRepo> getRepos() {
		return repos;
	}

	public void setRepos(List<GithubRepo> repos) {
		this.repos = repos;
	}

}
