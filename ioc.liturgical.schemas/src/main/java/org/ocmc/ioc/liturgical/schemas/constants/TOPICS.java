package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.common.base.Joiner;
import com.google.gson.JsonArray;

/**
 * Hierarchical specification of topics used in the database.
 * Each topic becomes a label if used with a node.
 * Each hyponymn also becomes a label.
 * The labels are added from the root down.
 * @author mac002
 *
 */
public enum TOPICS {
	ROOT("Root", "The root node of the topics.", null)
	, ABBREVIATION(
			"Abbreviation"
			,"An entry for an abbreviation or acronym."
			, TOPICS.ROOT
			)
	, COMMENTS_ROOT(
			"CommentsRoot"
			, "The root node for comments about a text or a relationship."
			, TOPICS.ROOT
			)
	, DICTIONARY_ENTRY(
			"DictionaryEntry"
			, "An entry for a dictionary"
			, TOPICS.ROOT
			)
	, LINGUISTICS_ROOT(
			"LinguisticsRoot"
			, "The root node for Information about a language: its lexicon, semantics, phonology, morphology, grammar."
			, TOPICS.ROOT
			)
	, NOTES_ROOT(
			"NoteRoot"
			, "The root node for notes on a text."
			, TOPICS.ROOT
			)
	, NOTE_TEXTUAL(
			"NoteTextual"
			, "A textual note."
			, TOPICS.NOTES_ROOT
			)
	, NOTE_USER(
			"NoteUser"
			, "The root node for personal notes made by a user."
			, TOPICS.NOTES_ROOT
			)
	, ONTOLOGY_ROOT("OntologyRoot", "The root node of the text ontology.", ROOT)
	, TABLES_ROOT("TablesRoot", "The root node of the Tables.", ROOT)
	, GOD(
			"God"
			, "The creator of all that exists."
			, TOPICS.ONTOLOGY_ROOT
			)
	, BEING(
			"Being"
			, "A living, created entity such as an angel, a human being, a plant, or an animal."
			, TOPICS.ONTOLOGY_ROOT
			)
	, ANIMAL(
			"Animal"
			, "A being that is a living organizm capable of independent movement.",
			TOPICS.BEING
			)
	, BIBLIOGRAPHY(
			"Bibliography"
			,"A bibliographical entry."
			, TOPICS.ROOT
			)
	, CONCEPT(
			"Concept"
			,"An abstract concept about something."
			, TOPICS.ONTOLOGY_ROOT
			)
	, EVENT(
			"Event"
			, "Something that happens or occurs."
			, TOPICS.ONTOLOGY_ROOT
			)
	, DEPENDENCY_TREE(
			"DependencyTree"
			, "Information used to render a dependency tree"
			, TOPICS.LINGUISTICS_ROOT
			)
	, GRAMMAR(
			"Grammar"
			, "Linguistic information about a word or its relationship to other words"
			, TOPICS.LINGUISTICS_ROOT
			)
	, GROUP(
			"Group"
			, "A collection of people."
			, TOPICS.ONTOLOGY_ROOT
			)
	, HUMAN(
			"Human"
			, "A human being."
			, TOPICS.BEING
			)
	, LEXICAL_ITEM(
			"LexicalItem"
			, "The lemmas and forms of a language"
			, TOPICS.LINGUISTICS_ROOT
			)
	, MYSTERY(
			"Mystery"
			, "Baptism, Chrismation, Confession, Marriage, Holy Communion, Holy Orders, or Unction."
			, TOPICS.CONCEPT
			)
	, OBJECT(
			"Object"
			, "A non-living entity, e,g, an artifact or tool."
			, TOPICS.ONTOLOGY_ROOT
			)
	, PLANT(
			"Plant"
			, "A being that is a living organizm not capable of independent movement."
			, TOPICS.BEING
			)
	, PLACE(
			"Place"
			, "A celestial or geographic location."
			, TOPICS.ONTOLOGY_ROOT
			)
	, PERSEUS_TREEBANK(
			"PerseusTreebank"
			, "Persesus Treebank."
			, TOPICS.GRAMMAR
			)
	, PERSEUS_TREEBANK_SENTENCE(
			"PtbSentence"
			, "A sentence from a text from the Persesus Treebank."
			, TOPICS.PERSEUS_TREEBANK
			)
	, PERSEUS_TREEBANK_WORD(
			"PtbWord"
			, "Grammatical Information about a token (e.g., a word or punctuation mark) from the Persesus Treebank."
			, TOPICS.PERSEUS_TREEBANK
			)
	, UD_TREEBANK(
			"UDtb"
			, "A Treebank based on Universal Dependency."
			, TOPICS.GRAMMAR
			)
	, UD_TREEBANK_SENTENCE(
			"UDtbSentence"
			, "A sentence from a text from a Universal Dependency Treebank."
			, TOPICS.UD_TREEBANK
			)
	, UD_TREEBANK_WORD(
			"UDtbWord"
			, "Grammatical Information about a token (e.g., a word or punctuation mark) from a Universal Dependency Treebank."
			, TOPICS.UD_TREEBANK
			)
	, PREFERENCES(
			"Preferences"
			,"A user's preferences when using the software."
			, TOPICS.ROOT
			)
	, ROLE(
			"Role"
			, "A role that entity can play or be."
			, TOPICS.ONTOLOGY_ROOT
			)
	, TABLE_LEXICON(
			"LexiconTable"
			, "A lexicon containing lemmas and their senses"
			, TOPICS.TABLES_ROOT
			)
	, GENERATION_UNIT_ROOT(
			"GenerationUnit"
			, "A container of information to generate a book or service."
			, TOPICS.ROOT
			)
	, TABLE_REALMS(
			"versionRealm"
			, "A table of Reams that are used with libraries"
			, TOPICS.TABLES_ROOT
			)
	, TABLE_LIBRARIES(
			"versionLibrary"
			, "A table of libraries for that identify the version of a translation"
			, TOPICS.TABLES_ROOT
			)
	, DAILY_READING(
			"dailyreading"
			,"An entry for a daily reading."
			, TOPICS.ROOT
			)
	, PERICOPE(
			"pericope"
			,"A selection of Biblical texts to be read as a unit."
			, TOPICS.ROOT
			)
	, SECTION(
			"Section"
			, "A subunit of a template."
			, TOPICS.GENERATION_UNIT_ROOT
			)
	, TEMPLATE(
			"Template"
			, "The topmost unit for generating a book or service."
			, TOPICS.GENERATION_UNIT_ROOT
			)
	, TEXT(
			"Text"
			, "A document containing written words."
			, TOPICS.ONTOLOGY_ROOT
			)
	, TEXT_CONCORDANCE(
			"TextConcordance"
			, "A document containing a substring from a text, used as a line in a concordance."
			, TOPICS.LINGUISTICS_ROOT
			)
	, TEXT_BIBLICAL(
			"Biblical"
			, "Biblical text."
			, TOPICS.TEXT
			)
	, TEXT_LITURGICAL(
			"Liturgical"
			, "Liturgical text."
			, TOPICS.TEXT
			)
	, TEXT_SPEECH(
			"Speech"
			, "Text that records a speech made by someone."
			, TOPICS.TEXT
			)
	, TOKEN_GRAMMAR(
			"TokenGrammar"
			, "Grammatical Information about a token (e.g., a word or punctuation mark)."
			, TOPICS.GRAMMAR
			)
	, UI_LABEL(
			"uilabel"
			,"An entry for a user interface label."
			, TOPICS.ROOT
			)
	, WORDNET(
			"WordNet"
			, "Lexical database for English, developed by Princeton University."
			, TOPICS.LEXICAL_ITEM
			)
	, WN_LEXICAL_ENTRY(
			"WnLexicalEntry"
			, "The dictionary lookup form for a word used by WordNet. It is the lemma plus the part of speech abbreviation."
			, TOPICS.WORDNET
			)
	, WN_LEXICAL_LEMMA(
			"WnLexicalEntry"
			, "The dictionary lookup form for a word used by WordNet."
			, TOPICS.WORDNET
			)
	, WN_LEXICAL_SENSE(
			"WnLexicalSense"
			, "The sense of a word used by WordNet."
			, TOPICS.WORDNET
			)
	, WN_LEXICAL_SYNSET(
			"WnLexicalSynset"
			, "A WordNet synset."
			, TOPICS.WORDNET
			)
	, WORD_CONTEXT(
			"WordContext"
			, "The semantic context for the sense of a word "
			, TOPICS.LEXICAL_ITEM
			)
	, WORD_INFLECTED(
			"WordInflected"
			, "The inflected form a lemma can take, e.g. the lemma λόγος can have the form λόγον "
			, TOPICS.LEXICAL_ITEM
			)
	, WORD_GRAMMAR(
			"WordGrammar"
			, "Grammatical Information about a word"
			, TOPICS.GRAMMAR
			)
	, WORD_LEMMA(
			"WordLemma"
			, "The Greek form of a word that is used to look it up in a lexicon, e.g. the inflected form λόγον is found in a lexicon as the lemma λόγος."
			, TOPICS.LEXICAL_ITEM
			)
	, WORD_LEMMA_GEV(
			"WordLemmaGev"
			, "The dictionary lookup form for a word used by the Global English Version translation of the liturgical texts."
			, TOPICS.LEXICAL_ITEM
			)
	, WORD_SENSE(
			"WordSense"
			, "The Greek sense of a word "
			, TOPICS.LEXICAL_ITEM
			)
	, WORD_SENSE_GEV(
			"WordSenseGev"
			, "The  sense of a word used by the Global English Version translation of the liturgical texts."
			, TOPICS.LEXICAL_ITEM
			)
	;

	public String label = "";
	public String description = "";
	public TOPICS hyponym;
	
	/**
	 * Constructor for a TOPIC
	 * @param label  used for this topic
	 * @param description of the topic 
	 * @param hyponym - is-a-kind-of
	 */
	private TOPICS(
			String label
			, String description
			, TOPICS hyponym
			) {
		this.label = label;
		this.description = description;
		this.hyponym = hyponym;
	}
		
	/**
	 * Find the Topic for this name
	 * @param name the name to search for
	 * @return ONTOLOGY_TOPICS topic
	 */
	public static TOPICS forName(String name) {
		for (TOPICS t : TOPICS.values()) {
			if (t.label.equals(name)) {
				return t;
			}
		}
		return null;
	}
	
	/**
	 * Creates a delimited string id for this topic, using the supplied library and key 
	 * @param library the library
	 * @param key the key
	 * @return a delimited string ID for this topic, using the supplied library and key
	 */
	public String toId(String library, String key) {
		return Joiner.on(Constants.ID_DELIMITER).join(library, this.label, key);
	}

	/**
	 * Gets a colon delimited set of strings that represent
	 * the ontology hierarchy for this entry,
	 * from more generic to less.
	 * @return a colon delimited set of label strings
	 */
	public String toDelimitedLabels() {
		return toLabels(this);
	}

	/**
	 * Returns the ontology hierarchy for this entry,
	 * from more generic to less.
	 * @return the labels as a list
	 */
	public List<String> toLabelsList() {
		List<String> result = new ArrayList<String>();
		String [] labels = toLabels(this).split(":");
		for (String label : labels) {
			if (!result.contains(label)) {
				result.add(label);
			}
		}
		return result;
	}

	/**
	 * Converts the topic and its hyponymns to a colon delimited string.
	 * This can be used in Neo4j as the labels for a node.
	 * @param topic
	 * @return the labels as a string
	 */
	private String toLabels(TOPICS topic) {
		StringBuffer result = new StringBuffer();
		if (topic == TOPICS.ROOT) {
			result.append(topic.label);
		} else {
			result.append(toLabels(topic.hyponym));
			if (result.length() > 0) {
				result.append(":");
			}
			result.append(topic.label);
		}
		return result.toString();
	}
	
	/**
	 * Get the keynames as a sorted list of DropDownItem
	 * @return the keynames as a sorted list of DropDownItem
	 */
	public static List<DropdownItem> keyNamesToDropdown() {
		List<DropdownItem> result = new ArrayList<DropdownItem>();
		TreeSet<String> values = new TreeSet<String>();
		for (TOPICS t : TOPICS.values()) {
			values.add(t.label);
		}
		for (String value : values) {
			result.add(new DropdownItem(value, value));
		}
		return result;
	}

	public static List<DropdownItem> keyNamesTrueOntologyToDropdown() {
		List<DropdownItem> result = new ArrayList<DropdownItem>();
		TreeSet<String> values = new TreeSet<String>();
		values.add(TOPICS.ANIMAL.label);
		values.add(TOPICS.BEING.label);
		values.add(TOPICS.CONCEPT.label);
		values.add(TOPICS.EVENT.label);
		values.add(TOPICS.GOD.label);
		values.add(TOPICS.GROUP.label);
		values.add(TOPICS.HUMAN.label);
		values.add(TOPICS.MYSTERY.label);
		values.add(TOPICS.OBJECT.label);
		values.add(TOPICS.PLACE.label);
		values.add(TOPICS.PLANT.label);
		values.add(TOPICS.ROLE.label);
		for (String value : values) {
			result.add(new DropdownItem(value, value));
		}
		return result;
	}

	public static List<DropdownItem> keyNamesForHyponymnToDropdown(
			TOPICS hyponymn
			) {
		List<DropdownItem> result = new ArrayList<DropdownItem>();
		TreeSet<String> values = new TreeSet<String>();
		for (TOPICS t : filterByTopicHyponymn(hyponymn)) {
			values.add(t.label);
		}
		for (String value : values) {
			result.add(new DropdownItem(value, value));
		}
		return result;
	}

	/**
	 * Get the keynames as a JsonArray of DropDownItem
	 * @return the keynames as a JsonArray of DropDownItem
	 */
	public static JsonArray topicLabelsToJsonArrayDropdown() {
		JsonArray result = new JsonArray();
		TreeSet<String> values = new TreeSet<String>();
		for (TOPICS t : TOPICS.values()) {
			values.add(t.label);
		}
		for (String value : values) {
			result.add(new DropdownItem(value, value).toJsonObject());
		}
		return result;
	}
	
	/**
	 * Get the hyponymn for this topic.  A topic is a-kind-of-x.  X is the hyponymn.
	 * Or, put another way, the hyponym is the super-topic and the topic is the sub-topic.
	 * @param topic the topic
	 * @return the hyponymn for this topic
	 */
	public static TOPICS getHyponym(TOPICS topic) {
		return topic.hyponym;
	}
	
	/**
	 * Walk the hierarchy to get the subroot (the one before
	 * the topmost ROOT), e.g. ONTOLOGY_ROOT
	 * @param topic the topic
	 * @return the subroot for this topic
	 */
	public static TOPICS getSubRoot(TOPICS topic) {
		TOPICS result = TOPICS.ROOT;
		if (topic.hyponym == TOPICS.ROOT) {
			result = topic;
		} else {
			return getHyponym(topic.hyponym);
		}
		return result;
	}
	
	/**
	 * Returns a list of TOPICS whose hyponymn matches the supplied parameter.
	 * For example, filterByTopicHyponymn(TOPICS.
	 * @param hyponymn the hyponymn
	 * @return list of topics whose hyponymn matches the supplied parameter
	 */
	public static List<TOPICS> filterByTopicHyponymn(TOPICS hyponymn) {
		List<TOPICS> result = new ArrayList<TOPICS>();
		for (TOPICS t : TOPICS.values()) {
			if (t != TOPICS.ROOT) {
				if (t.hyponym.equals(hyponymn)) {
					result.add(t);
				} else {
					if (
							t.hyponym == TOPICS.BEING
							|| t.hyponym == TOPICS.CONCEPT
							) {
						result.add(t);
					}
				}
			}
		}
		return result;
	}


}

