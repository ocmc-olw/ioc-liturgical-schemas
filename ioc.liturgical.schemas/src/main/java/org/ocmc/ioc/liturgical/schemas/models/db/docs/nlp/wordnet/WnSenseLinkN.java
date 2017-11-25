package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.wordnet;

import com.github.reinert.jjschema.Attributes;

import org.ocmc.ioc.liturgical.schemas.constants.RELATIONSHIP_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;

@Attributes(title = "The sense of a noun in WordNet", description = "This is a link that records information about the sense of a word used in the WordNet lexical database that is a noun.")
public class WnSenseLinkN extends WnSenseLink {
	
	private static TOPICS topic = TOPICS.WN_LEXICAL_SENSE;
	private static RELATIONSHIP_TYPES type = RELATIONSHIP_TYPES.SENSE_N;
	private static String schema = WnSenseLinkN.class.getSimpleName();
	private static double version = 1.1;
	
	public WnSenseLinkN(
			String wid
			, int senseNbr
			, String sid
			) {
		super(
				wid
				, senseNbr
				, sid
				, type
		);
	}

}
