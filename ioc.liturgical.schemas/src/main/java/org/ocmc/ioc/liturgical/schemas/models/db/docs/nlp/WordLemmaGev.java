package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.apache.commons.lang3.StringUtils;
import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Lemma Form of a Word for GEV", description = "This is a doc that records information about the lemma form of a word used in the Global English Version translations.")
public class WordLemmaGev extends LTKDb {
	private static TOPICS topic = TOPICS.WORD_LEMMA_GEV;
	private static String schema = WordLemmaGev.class.getSimpleName();
	private static double version = 1.1;
	
	@Expose String lemma = "";
	@Expose String retrievalForm = "";
	@Expose String source = "";
	
	public WordLemmaGev(
			String lemma
			) {
		super(
				LIBRARIES.LINGUISTICS.toSystemDomain()
				, topic.label
				, lemma
				, schema
				,  version
				, topic
				);
		this.lemma = lemma;
		if (StringUtils.isNumeric(lemma.substring(lemma.length()-1))) {
			this.lemma = lemma.substring(0, lemma.indexOf(" "));
			this.retrievalForm = lemma.replace(" ", "_");
		} else {
			this.retrievalForm = lemma.replaceAll(" ", "-");
		}
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRetrievalForm() {
		return retrievalForm;
	}

	public void setRetrievalForm(String retrievalForm) {
		this.retrievalForm = retrievalForm;
	}

}
