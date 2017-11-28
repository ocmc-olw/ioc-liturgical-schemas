package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.utils.Tuple;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.DEPENDENCY_LABELS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.DEPENDENCY_LABEL_MAPPER;

import java.util.ArrayList;
import java.util.List;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "DependencyTree", description = "Data for a Dependency Tree")
public class DependencyTree extends LTKDb {
	
	private static String schema = DependencyTree.class.getSimpleName();
	private static double serialVersion = 1.1;
	private static TOPICS ontologyTopic = TOPICS.DEPENDENCY_TREE;
	
	@Expose List<TokenAnalysis> nodes = new ArrayList<TokenAnalysis>();

	public DependencyTree(
			String key
			) {
		super(
				LIBRARIES.LINGUISTICS.toSystemDomain()
				, ontologyTopic.label
				, key
				, schema
				, serialVersion
				, ontologyTopic
				);
	}

	public List<TokenAnalysis> getNodes() {
		return nodes;
	}

	public void setNodes(List<TokenAnalysis> nodes) {
		this.nodes = nodes;
	}
	
	public List<JsonObject> nodesToJsonObjectList() {
		List<JsonObject> result = new ArrayList<JsonObject>();
		for (TokenAnalysis tokenAnalysis : this.nodes) {
			result.add(tokenAnalysis.toJsonObject());
		}
		return result;
	}
		
}
