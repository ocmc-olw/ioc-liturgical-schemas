package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.ocmc.ioc.liturgical.schemas.constants.nlp.PARTS_OF_SPEECH;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGrammarAnalysisGenderNumberCase;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Noun", description = "This is a doc that records information about a grammatical analysis of a noun.")
public class Noun extends LTKDbGrammarAnalysisGenderNumberCase {
	
	private static String schema = Noun.class.getSimpleName();
	private static double version = 1.1;
	
	   @Expose String definite = "_";
	
	public Noun(
			String form
			, String key
			) {
		super(form, key, schema, version);
		super.setPos(PARTS_OF_SPEECH.NOUN);
	}

	public String getDefinite() {
		return definite;
	}

	public void setDefinite(String definite) {
		this.definite = definite;
	}

}
