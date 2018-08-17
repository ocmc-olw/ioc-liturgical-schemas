package org.ocmc.ioc.liturgical.schemas.models.readings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

public enum DATA_SOURCES {
	GITHUB(
			""
			,""
			,"Pulled from Github"
			,""
			)
	, OCA_READINGS(
			"https://oca.org/readings/monthly"
			,"Daily Readings from Orthodox Church in America website"
			,"Pulled from OCA website"
			,""
			)
	, ONLINE(""
			,""
			,"Entered online by a user"
			,""
			)
	, MACHINE_LEARNING(
			""
			,""
			,"Entered by a Machine Learning Model."
			,""
			)
	, PERSEUS(
			""
			,""
			,"Pulled from Perseus"
			,""
			)
	, UD_ENGLISH_EWT(
			"https://github.com/UniversalDependencies/UD_English-EWT.git"
			,"UDEnglishEWT"
			,"UD Treebank - English Web Treebank"
			,"en_ewt-ud-train.conllu"
			)
	, UD_GREEK_GDT("https://github.com/UniversalDependencies/UD_Greek-GDT.git"
			,"UDGreekGDT"
			,"UD Treebank - Modern Greek Dependency Treebank"
			,"el_gdt-ud-train.conllu"
			)
	, UD_ANCIENT_GREEK_PERSEUS(
			"https://github.com/UniversalDependencies/UD_Ancient_Greek-Perseus.git"
			,"UDAncientGreekPerseus"
			, "UD Treebank - Ancient Greek Perseus - Tufts University"
			,"grc_perseus-ud-train.conllu"
			)
	, UD_ANCIENT_GREEK_PROIEL(
			"https://github.com/UniversalDependencies/UD_Ancient_Greek-PROIEL.git"
			,"ADAncientGreekPROIEL"
			,"UD Treebank - Ancient Greek PROIEL - University of Oslo"
			,"grc_proiel-ud-train.conllu"
			)
	, UNKNOWN(
			""
			,""
			,"Unknown"
			,""
			)
	, WORDNET(
			""
			,""
			,"From Wordnet"
			,""
			)
	;
	
	public String gitCloneUrl = "";
	public  String nodeLabel = "";
	public String description = "";
	public String trainingFile = "";
	
	private DATA_SOURCES (
			String gitCloneUrl
			, String nodeLabel
			, String description
			, String trainingFile
			) {
		this.gitCloneUrl = gitCloneUrl;
		this.nodeLabel = nodeLabel;
		this.description = description;
		this.trainingFile = trainingFile;
	}
	
	public static DATA_SOURCES forName(String name) {
		for (DATA_SOURCES v : DATA_SOURCES.values()) {
			if (v.name().equals(name)) {
				return v;
			}
		}
		return DATA_SOURCES.UNKNOWN;
	}
	
	/**
	 * Get DATA_SOURCES that are for the Universal Dependencies Github site
	 * @return the list of data sources for Universal Dependencies
	 */
	public static List<DATA_SOURCES> getUniversalDependencies() {
		List<DATA_SOURCES> list = new ArrayList<DATA_SOURCES>();
		for (DATA_SOURCES v : DATA_SOURCES.values()) {
			if (v.name().startsWith("UD_")) {
				list.add(v);
			}
		}
		Collections.sort(list);
		return list;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (DATA_SOURCES e : DATA_SOURCES.getUniversalDependencies()) {
    		result.add(new DropdownItem(e.description, e.name()).toJsonObject());
    	}
    	return result;
    }

}
