package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

public class WordAnalyses extends AbstractModel {

	@Expose public String token = "";
	@Expose public List<WordAnalysis> analyses = new ArrayList<WordAnalysis>();
	
	public WordAnalyses(
			String token
			) {
		super();
		this.token = token.trim();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public void addAnalysis(WordAnalysis analysis) {
		this.analyses.add(analysis);
	}

	public List<WordAnalysis> getAnalyses() {
		return analyses;
	}

	public void setAnalyses(List<WordAnalysis> analyses) {
		this.analyses = analyses;
	}

}
