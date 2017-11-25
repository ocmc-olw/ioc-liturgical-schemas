package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTK;

public class TokenCreateForm extends LTK {

	private static String schema = TokenCreateForm.class.getSimpleName();
	private static double serialVersion = 1.1;
	private static TOPICS ontologyTopic = TOPICS.WORD_INFLECTED;

	public String id = "";
    public String dependsOn = "";
    public  String token = "";
    public  String lemma = "";
    public  String gloss = "";
    public String label = "";
    public String grammar = "";

    public TokenCreateForm(
    		String textId
    		, String seq
    		) {
		super(
				"TBD" // library
				, textId // topic
				, seq // key
				, schema
				, serialVersion
				, ontologyTopic
				);
	}

}
