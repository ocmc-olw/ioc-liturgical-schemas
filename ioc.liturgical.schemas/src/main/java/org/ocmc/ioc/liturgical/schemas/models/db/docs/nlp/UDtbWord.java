package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbTokenAnalysis;

import com.github.reinert.jjschema.Attributes;

/**
 * Holds information about the grammatical analysis of a token from a text.
 * A token can be a word or a punctuation mark.
 * 
 * Note the difference between a TokenAnalysis and a WordAnalysis.
 * A TokenAnalysis is the grammatical analysis of a specific token 
 * occurring in a specific text.  A WordAnalysis has no direct association
 * with any particular text.  It is just a potential analysis for a given inflected form.
 * 
 * This class is for a token from a Universal Dependency treebank.
 * 
 * @author mac002
 * @see WordAnalysis
 *
 */
@Attributes(title = "Universal Dependency Treebank Word Analysis", description = "Grammatical analysis of a token from a Universal Dependency Treebank")
public class UDtbWord extends LTKDbTokenAnalysis {
	
	private static String schema = UDtbWord.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.UD_TREEBANK_WORD;

	@Attributes(id="top", required = false, description = "UPOSTAG - Universal Part of Speech")
    @Expose String upostag = "";

	@Attributes(id="top", required = false, description = "XPOSTAG - Language Specific Part of Speech")
    @Expose String xpostag = "_";

	@Attributes(id="top", required = false, description = "FEATS - Morphological Features")
    @Expose String feats = "_";

	@Attributes(id="top", required = false, description = "DEPS - List of secondary dependencies (head-deprel pairs)")
    @Expose String deps = "_";

	@Attributes(id="top", required = false, description = "MISC - Any other annotation")
    @Expose String misc = "_";

	public UDtbWord(
			String topic
			, String key
			) {
		super(
				topic
				, key
				, schema
				, version
				, ontoTopic
				);
	}

	public String getUpostag() {
		return upostag;
	}

	public void setUpostag(String postag) {
		this.upostag = postag;
	}

	public String getXpostag() {
		return xpostag;
	}

	public void setXpostag(String xpostag) {
		this.xpostag = xpostag;
	}

	public String getFeats() {
		return feats;
	}

	public void setFeats(String feats) {
		this.feats = feats;
	}

	public String getDeps() {
		return deps;
	}

	public void setDeps(String deps) {
		this.deps = deps;
	}

	public String getMisc() {
		return misc;
	}

	public void setMisc(String misc) {
		this.misc = misc;
	}

}
