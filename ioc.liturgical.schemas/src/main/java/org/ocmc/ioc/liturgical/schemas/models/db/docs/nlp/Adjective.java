package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.ocmc.ioc.liturgical.schemas.constants.nlp.PARTS_OF_SPEECH;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGrammarAnalysisGenderNumberCase;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Adjective", description = "This is a doc that records information about a grammatical analysis of an adjective.")
public class Adjective extends LTKDbGrammarAnalysisGenderNumberCase {
	
	private static String schema = Adjective.class.getSimpleName();
	private static double version = 1.1;
	
	   @Expose String definite = "_";
	   @Expose String degree = "_";
	   @Expose String numType = "_";
	   @Expose String pronType = "_";

	public Adjective(
			String form
			, String key
			) {
		super(form, key, schema, version);
		super.setPos(PARTS_OF_SPEECH.ADJ);
	}

	public String getDefinite() {
		return definite;
	}

	public void setDefinite(String definite) {
		this.definite = definite;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getNumType() {
		return numType;
	}

	public void setNumType(String numType) {
		this.numType = numType;
	}

	public String getPronType() {
		return pronType;
	}

	public void setPronType(String pronType) {
		this.pronType = pronType;
	}

}
