package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_POS {
	ADJ(
			"ADJ"
			, "adjective"
			, "Adjectives are words that typically modify nouns and specify their properties or attributes."
			,""
			, ""
			)
	, ADP(
			"ADP"
			, "adposition"
			, "Adposition is a cover term for prepositions and postpositions. Adpositions belong to a closed set of items that occur before (preposition) or after (postposition) a complement composed of a noun phrase, noun, pronoun, or clause that functions as a noun phrase, and that form a single structure with the complement to express its grammatical and semantic relation to another unit within a clause."
			,""
			, ""
			)
	, ADV(
			"ADV"
			, "adverb"
			, "Adverbs are words that typically modify verbs for such categories as time, place, direction or manner. They may also modify adjectives and other adverbs, as in very briefly or arguably wrong."
			,""
			, ""
			)
	, AUX(
			"auxiliary"
			, "auxiliary"
			, "An auxiliary is a function word that accompanies the lexical verb of a verb phrase and expresses grammatical distinctions not carried by the lexical verb, such as person, number, tense, mood, aspect, voice or evidentiality. It is often a verb (which may have non-auxiliary uses as well) but many languages have nonverbal TAME markers and these should also be tagged AUX. The class AUX also include copulas (in the narrow sense of pure linking words for nonverbal predication)."
			,""
			, ""
			)
	, CCONJ(
			"CCONJ"
			, "coordinating conjunction"
			, "A coordinating conjunction is a word that links words or larger constituents without syntactically subordinating one to the other and expresses a semantic relationship between them."
			,""
			, ""
			)
	, DET(
			"DET"
			, "determiner"
			, "Determiners are words that modify nouns or noun phrases and express the reference of the noun phrase in context. That is, a determiner may indicate whether the noun is referring to a definite or indefinite element of a class, to a closer or more distant element, to an element belonging to a specified person or thing, to a particular number or quantity, etc."
			,""
			, ""
			)
	, INTJ(
			"INTJ"
			, "interjection"
			, "An interjection is a word that is used most often as an exclamation or part of an exclamation. It typically expresses an emotional reaction, is not syntactically related to other accompanying expressions, and may include a combination of sounds not otherwise found in the language."
			,""
			, ""
			)
	, NOUN(
			"NOUN"
			, "noun"
			, "Nouns are a part of speech typically denoting a person, place, thing, animal or idea. The NOUN tag is intended for common nouns only. See PROPN for proper nouns and PRON for pronouns."
			,""
			, ""
			)
	, NUM(
			"NUM"
			, "numeral"
			, "A numeral is a word, functioning most typically as a determiner, adjective or pronoun, that expresses a number and a relation to the number, such as quantity, sequence, frequency or fraction."
			,""
			, ""
			)
	, PART(
			"PART"
			, "particle"
			, "Particles are function words that must be associated with another word or phrase to impart meaning and that do not satisfy definitions of other universal parts of speech (e.g. adpositions, coordinating conjunctions, subordinating conjunctions or auxiliary verbs). Particles may encode grammatical categories such as negation, mood, tense etc. Particles are normally not inflected, although exceptions may occur."
			,""
			, ""
			)
	, PRON(
			"PRON"
			, "pronoun"
			, "Pronouns are words that substitute for nouns or noun phrases, whose meaning is recoverable from the linguistic or extralinguistic context. Pronouns under this definition function like nouns."
			,""
			, ""
			)
	, PROPN(
			"PROPN"
			, "proper noun"
			, "A proper noun is a noun (or nominal content word) that is the name (or part of the name) of a specific individual, place, or object. Note that PROPN is only used for the subclass of nouns that are used as names and that often exhibit special syntactic properties (such as occurring without an article in the singular in English). "
			,""
			, ""
			)
	, PUNCT(
			"PUNCT"
			, "punctuation"
			, "Punctuation marks are non-alphabetical characters and character groups used in many languages to delimit linguistic units in printed text. Punctuation marks are non-alphabetical characters and character groups used in many languages to delimit linguistic units in printed text."
			,""
			, ""
			)
	, SCONJ(
			"SCONJ"
			, "subordinating conjunction"
			, "A subordinating conjunction is a conjunction that links constructions by making one of them a constituent of the other. The subordinating conjunction typically marks the incorporated constituent which has the status of a (subordinate) clause."
			,""
			, ""
			)
	, SYM(
			"SYM"
			, "symbol"
			, "A symbol is a word-like entity that differs from ordinary words by form, function, or both."
			,""
			, ""
			)
	, VERB(
			"VERB"
			, "verb"
			, "A verb is a member of the syntactic class of words that typically signal events and actions, can constitute a minimal predicate in a clause, and govern the number and types of other constituents which may occur in the clause. Verbs are often associated with grammatical categories like tense, mood, aspect and voice, which can either be expressed inflectionally or using auxilliary verbs or particles."
			,""
			, ""
			)
	, X(
			"X"
			, "other"
			, "The tag X is used for words that for some reason cannot be assigned a real part-of-speech category. It should be used very restrictively."
			,""
			, ""
			)
	, USP(
			"_"
			,"unspecified"
			,"unspecified"
			,""
			, ""
			)
	;
	public String keyname = "";
	public String fullname = "";
	public String decription = "";
	public String parse = "";
	public String gev = "";
	
	private UD_POS(
			String keyname
			, String fullname
			, String description
			, String parse
			, String gev
			) {
		this.keyname = keyname;
		this.fullname = fullname;
		this.decription = description;
		this.parse = parse;
		this.gev = gev;
	}
		
	/**
	 * Find the Enum value for this keyname
	 * @param name to search for
	 * @return Entry the enum for that name
	 */
	public static UD_POS forName(String name) {
		for (UD_POS v : UD_POS.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_POS.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_POS e : UD_POS.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_POS e : UD_POS.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
