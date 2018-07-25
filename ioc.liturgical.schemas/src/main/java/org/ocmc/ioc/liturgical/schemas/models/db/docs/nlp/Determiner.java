package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.ocmc.ioc.liturgical.schemas.constants.nlp.PARTS_OF_SPEECH;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGrammarAnalysisGenderNumberCase;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Determiner", description = "Determiners are words that modify nouns or noun phrases and express the reference of the noun phrase in context. That is, a determiner may indicate whether the noun is referring to a definite or indefinite element of a class, to a closer or more distant element, to an element belonging to a specified person or thing, to a particular number or quantity, etc.")
public class Determiner extends LTKDbGrammarAnalysisGenderNumberCase {
	
	private static String schema = Determiner.class.getSimpleName();
	private static double version = 1.1;
	
	   @Expose String definite = "_";

	public Determiner(
			String form
			, String key
			) {
		super(form, key, schema, version);
		super.setPos(PARTS_OF_SPEECH.ARTICLE);
	}


	public String getDefinite() {
		return definite;
	}


	public void setDefinite(String definite) {
		this.definite = definite;
	}

}
