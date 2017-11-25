package org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp;

import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbLexicalItem;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Lexical Form", description = "This is a doc that records information about a Greek lexical form.  The form is the word as it appears in text.  A form maps to a lemma.")
public class WordInflected extends LTKDbLexicalItem {
	private static TOPICS topic = TOPICS.WORD_INFLECTED;

	private static String schema = WordInflected.class.getSimpleName();
	private static double version = 1.1;
	
	public WordInflected(
			String form
			, int frequency
			) {
		super(topic, form, frequency, schema, version);
	}

}
