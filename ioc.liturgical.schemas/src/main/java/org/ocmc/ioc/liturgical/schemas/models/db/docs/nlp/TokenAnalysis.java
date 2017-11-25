package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbTokenAnalysis;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKTokenAnalysisCreateForm;

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
 * @author mac002
 * @see WordAnalysis
 *
 */
@Attributes(title = "Token Analysis", description = "Grammatical analysis of a token")
public class TokenAnalysis extends LTKDbTokenAnalysis {
	
	private static String schema = TokenAnalysis.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.TOKEN_GRAMMAR;

	public TokenAnalysis(
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

	public TokenAnalysis(
			String topic
			, String key
			, LTKTokenAnalysisCreateForm form
			) {
		super(
				schema
				,  version
				, ontoTopic
				, form
				);
	}

}
