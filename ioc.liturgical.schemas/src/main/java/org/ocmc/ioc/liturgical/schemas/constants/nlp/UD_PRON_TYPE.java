package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_PRON_TYPE {
	ART(
			"Art"
			, "article"
			, "Article is a special case of determiner that bears the feature of definiteness (in other languages, the feature may be marked directly on nouns)."
			,""
			, ""
			)
	, DEM(
		"Dem"
		, "demonstrative pronoun, determiner, numeral or adverb"
		, "These are often parallel to interrogatives. "
		,""
		, ""
		)
	, EMP(
			"Emp"
			, "emphatic determiner"
			, "Emphatic pro-adjectives (determiners) emphasize the nominal they depend on. There are similarities with reflexive and demonstrative pronouns / determiners."
			,""
			, ""
			)
	, EXC(
			"Exc"
			,"exclamative determiner"
			,"Exclamative pro-adjectives (determiners) express the speaker’s surprise towards the modified noun, e.g. what in “What a surprise!” In many languages, exclamative determiners are recruited from the set of interrogative determiners. Therefore, not all tagsets distinguish them."
			,""
			, ""
			)
	, IND(
			"Ind"
			,"indefinite"
			,"In languages where Spec is distinguished the value Ind is interpreted as non-specific indefinite, i.e. 'any (one) stick'."
			,""
			, ""
			)
	, INT(
			"Int"
			,"interrogative pronoun, determiner, numeral or adverb"
			,"to be explained"
			,"Note that possessive interrogative determiners (whose) can be distinguished by the Poss feature."
			, ""
			)
	, NEG(
			"Neg"
			,"negative"
			,"e.g., 'he did not come', 'not big'"
			,""
			, ""
			)
	, PRS(
			"Prs"
			,"personal or possessive personal pronoun or determiner"
			,"See also the Poss feature that distinguishes normal personal pronouns from possessives. Note that Prs also includes reflexive personal/possessive pronouns."
			,"tbd"
			, ""
			)
	, RCP(
			"Rcp"
			,"reciprical pronoun"
			,"each other"
			,""
			, ""
			)
	, REL(
			"Rel"
			,"relative pronoun, determiner, numeral or adverb"
			,"Note that in many languages this class heavily overlaps with interrogatives, yet there are pronouns that are only relative, and in some languages (Bulgarian, Hindi) the two classes are distinct."
			,""
			, ""
			)
	, TOT(
			"Tot"
			,"total (collective) pronoun, determiner or adverb"
			,"e.g., every, everybody, all, always"
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
	
	private UD_PRON_TYPE(
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
	public static UD_PRON_TYPE forName(String name) {
		for (UD_PRON_TYPE v : UD_PRON_TYPE.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_PRON_TYPE.USP;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_PRON_TYPE e : UD_PRON_TYPE.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_PRON_TYPE e : UD_PRON_TYPE.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
