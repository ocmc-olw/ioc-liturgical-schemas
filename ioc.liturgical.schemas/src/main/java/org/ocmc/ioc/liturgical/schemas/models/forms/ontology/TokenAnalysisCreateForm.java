package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKTokenAnalysisCreateForm;

import com.github.reinert.jjschema.Attributes;

/**
 * Provides a means to store information to render a client side node of
 * a dependency diagram.
 * 
 * Note that the long-term solution is to store such information using the
 * NLP model  corresponding to the part-of-speech of the token.
 * 
 * So, this is just a temporary solution.
 * 
 * @author mac002
 *
 */
@Attributes(title = "Tree Node", description = "Information to render a node of a depenency diagram")
public class TokenAnalysisCreateForm extends LTKTokenAnalysisCreateForm {
	
	private static String schema = TokenAnalysisCreateForm.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.TOKEN_GRAMMAR;

	public TokenAnalysisCreateForm(
			String topic
			, String key
			) {
		super(
				LIBRARIES.LINGUISTICS.toSystemDomain()
				, topic
				, key
				, schema
				,  version
				, ontoTopic
				);
	}

}
