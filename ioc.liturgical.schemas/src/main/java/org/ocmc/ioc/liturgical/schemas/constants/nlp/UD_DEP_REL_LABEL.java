package org.ocmc.ioc.liturgical.schemas.constants.nlp;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public enum UD_DEP_REL_LABEL {
	ACL(
			"acl"
			,"clausal modifier of noun (adjectival clause)"
			,"acl stands for finite and non-finite clauses that modify a nominal. The acl relation contrasts with the advcl relation, which is used for adverbial clauses that modify a predicate. The head of the acl relation is the noun that is modified, and the dependent is the head of the clause that modifies the noun."
			,""
			, ""
			)
	, ADVCL(
			"advcl"
			,"adverbial clause modifier"
			,"An adverbial clause modifier is a clause which modifies a verb or other predicate (adjective, etc.), as a modifier not as a core complement. This includes things such as a temporal clause, consequence, conditional clause, purpose clause, etc. The dependent must be clausal (or else it is an advmod) and the dependent is the main predicate of the clause."
			,""
			, ""
			)
	, ADVCL_RELCL(
			"advcl:relcl"
			,"adverbial clause modifier - relative clause"
			, ""
			,""
			, ""
			)
	, ADVMOD(
			"advmod"
			,"adverbial Modifier"
			,"An adverbial modifier of a word is a (non-clausal) adverb or adverbial phrase that serves to modify a predicate or a modifier word."
			,""
			, ""
			)
	, AMOD(
			"amod"
			,"adjectival modifier"
			,"An adjectival modifier of a noun is any adjectival phrase that serves to modify the meaning of the noun."
			,""
			, ""
			)
	, APPOS(
			"appos"
			,"appostional modifier"
			,"An appositional modifier of a noun is a nominal immediately following the first noun that serves to define, modify, name, or describe that noun. It includes parenthesized examples, as well as defining abbreviations in one of these structures."
			,""
			, ""
			)
	, AUX(
			"aux"
			,"auxiliary"
			,"An aux (auxiliary) of a clause is a function word associated with a verbal predicate that expresses categories such as tense, mood, aspect, voice or evidentiality. It is often a verb (which may have non-auxiliary uses as well) but many languages have nonverbal TAME markers and these are also treated as instances of aux."
			,""
			, ""
			)
	, AUX_PASS(
			"aux:pass"
			,"auxiliary - passive"
			, ""
			,""
			, ""
			)
	, CASE(
			"case"
			,"case marking"
			,"The case relation is used for any case-marking element which is treated as a separate syntactic word (including prepositions, postpositions, and clitic case markers). Case-marking elements are treated as dependents of the noun they attach to or introduce. (Thus, contrary to SD, UD abandons treating a preposition as a mediator between a modified word and its object.) The case relation aims at providing a more uniform analysis of nominal elements, prepositions and case in morphologically rich languages: a nominal in an oblique case will receive the same dependency structure as a nominal introduced by an adposition."
			,""
			, ""
			)
	, CC(
			"cc"
			,"coordinating conjunction"
			,"A cc is the relation between a conjunct and a preceding coordinating conjunction."
			,""
			, ""
			)
	, CCOMP(
			"ccomp"
			,"clausal complement"
			,"A clausal complement of a verb or adjective is a dependent clause which is a core argument. That is, it functions like an object of the verb, or adjective."
			,""
			, ""
			)
	, CLF(
			"clf"
			,"classifier"
			,"A clf (classifier) is a word which accompanies a noun in certain grammatical contexts....The clf function is intended for languages which have highly grammaticalized systems of classifiers."
			,""
			, ""
			)
	, COMPOUND(
			"compound"
			,"compound"
			,"The compound relation is one of three relations for multiword expressions (MWEs) (the other two being fixed and flat). It is used for 1) any kind of X0 compounding: noun compounds (e.g., phone book), but also verb and adjective compounds that are more common in other languages (such as Persian or Japanese light verb constructions). 2) for particle verbs (with the subtype compound:prt). 3) for serial verbs (with the subtype compound:svc)."
			,""
			, ""
			)
	, COMPOUND_PRT(
			"compound:prt"
			,"compound for Particle Word"
			,"The compound relation is one of three relations for multiword expressions (MWEs) (the other two being fixed and flat). It is used for 1) any kind of X0 compounding: noun compounds (e.g., phone book), but also verb and adjective compounds that are more common in other languages (such as Persian or Japanese light verb constructions). 2) for particle verbs (with the subtype compound:prt). 3) for serial verbs (with the subtype compound:svc)."
			,""
			, ""
			)
	, COMPOUND_SVC(
			"compound:svc"
			,"compound for Serial Verb"
			,"The compound relation is one of three relations for multiword expressions (MWEs) (the other two being fixed and flat). It is used for 1) any kind of X0 compounding: noun compounds (e.g., phone book), but also verb and adjective compounds that are more common in other languages (such as Persian or Japanese light verb constructions). 2) for particle verbs (with the subtype compound:prt). 3) for serial verbs (with the subtype compound:svc)."
			,""
			, ""
			)
	, CONJ(
			"conj"
			,"conjunct"
			,"A conjunct is the relation between two elements connected by a coordinating conjunction, such as and, or, etc. We treat conjunctions asymmetrically: The head of the relation is the first conjunct and all the other conjuncts depend on it via the conj relation."
			,""
			, ""
			)
	, COP(
			"cop"
			,"copula"
			,"A cop (copula) is the relation of a function word used to link a subject to a nonverbal predicate. It is often a verb but nonverbal copulas are also frequent in the world’s languages. The cop relation should only be used for pure copulas that add at most TAME categories to the meaning of the predicate, which means that most languages have at most one copula, and only when the nonverbal predicate is treated as the head of the clause."
			,""
			, ""
			)
	, CSUBJ(
			"csubj"
			,"clausal subject"
			,"A clausal subject is a clausal syntactic subject of a clause, i.e., the subject is itself a clause. The governor of this relation might not always be a verb: when the verb is a copular verb, the root of the clause is the complement of the copular verb. The dependent is the main lexical verb or other predicate of the subject clause. In the following examples, what she said (that is, said) is the clausal subject of makes and interesting, respectively. The csubj relation is also used for the clausal subject of a passive verb or verb group. For languages that have a grammaticalized passive transformation, it is strongly recommended to use the subtype csubj:pass in such cases."
			,""
			, ""
			)
	, CSUBJ_PASS(
			"csubj:pass"
			,"clausal subject - Grammaticalized Passive"
			,"A clausal subject is a clausal syntactic subject of a clause, i.e., the subject is itself a clause. The governor of this relation might not always be a verb: when the verb is a copular verb, the root of the clause is the complement of the copular verb. The dependent is the main lexical verb or other predicate of the subject clause. In the following examples, what she said (that is, said) is the clausal subject of makes and interesting, respectively. The csubj relation is also used for the clausal subject of a passive verb or verb group. For languages that have a grammaticalized passive transformation, it is strongly recommended to use the subtype csubj:pass in such cases."
			,""
			, ""
			)
	, DEP(
			"dep"
			,"unspecified dependency"
			,"A dependency can be labeled as dep when it is impossible to determine a more precise relation. This may be because of a weird grammatical construction, or a limitation in conversion or parsing software. The use of dep should be avoided as much as possible."
			,""
			, ""
			)
	, DET(
			"det"
			,"determiner"
			,"The relation determiner (det) holds between a nominal head and its determiner. Most commonly, a word of POS DET will have the relation det and vice versa. "
			,""
			, ""
			)
	, DISCOURCE(
			"discourse"
			,"discourse element"
			,"This is used for interjections and other discourse particles and elements (which are not clearly linked to the structure of the sentence, except in an expressive way). We generally follow the guidelines of what the Penn Treebanks count as an INTJ. They define this to include: interjections (oh, uh-huh, Welcome), fillers (um, ah), and discourse markers (well, like, actually, but not you know). These discourse elements are attached to the head of the most relevant nearby clause, which is why they are grouped with non-core clausal dependents even though they are normally not dependents of the predicates as such. "
			,""
			, ""
			)
	, DISLOCATED(
			"dislocated"
			,"dislocated elements"
			,"The dislocated relation is used for fronted or postposed elements that do not fulfill the usual core grammatical relations of a sentence. These elements often appear to be in the periphery of the sentence, and may be separated off with a comma intonation. It is used for fronted elements that introduce the topic of a sentence, as in Japanese and Greek. The dislocated element attaches to the head of the clause to which it belongs."
			,""
			, ""
			)
	, EXPL(
			"expl"
			,"expletive"
			,"This relation captures expletive or pleonastic nominals. These are nominals that appear in an argument position of a predicate but which do not themselves satisfy any of the semantic roles of the predicate. The main predicate of the clause (the verb or predicate adjective or noun) is the governor. In English, this is the case for some uses of it and there: the existential there, and it when used in extraposition constructions. (Note that both it and there also have non-expletive uses.)"
			,""
			, ""
			)
	, EXPL_PV(
			"expl:pv"
			,"expletive - reflexive clitic attached to pronominal verb, aka reflexive verb"
			, "for reflexive clitics attached to inherently reflexive verbs,  aka pronominal verb."
			,""
			, ""
			)
	, EXPL_PASS(
			"expl:pass"
			,"expletive - reflexive verb attached to transitive verb and acting as a passive voice marker"
			, "for reflexive clitics attached to transitive verbs and acting as a passive voice marker."
			,""
			, ""
			)
	, EXPL_IMPERS(
			"expl:impers"
			,"expletive - impersonal usage)"
			,"for impersonal usage (works also with intransitive verbs)"
			,""
			, ""
			)
	, FIXED(
			"fixed"
			,"fixed multiword expresion"
			,"The fixed relation is one of the three relations for multiword expressions (MWEs) (the other two being flat and compound). It is used for certain fixed grammaticized expressions that behave like function words or short adverbials. Fixed MWEs are annotated in a flat structure, where all subsequent words in the expression are attached to the first one using the fixed label. The assumption is that these expressions do not have any internal syntactic structure (except from a historical perspective) and that the structural annotation is in principle arbitrary. In practice, however, it is highly desirable to use a consistent annotation of all fixed MWEs in all languages."
			,""
			, ""
			)
	, FLAT(
			"flat"
			,"flat multiword expression"
			,"The flat relation is one of three relations for multiword expressions multiword expressions (MWEs) in UD (the other two being fixed and compound). It is used for exocentric (headless) semi-fixed MWEs like names (Hillary Rodham Clinton) and dates (24 December). It contrasts with fixed, which applies to completely fixed grammaticized (function word-like) MWEs (like in spite of), and with compound, which applies to endocentric (headed) MWEs (like apple pie). Flat MWEs are annotated with a flat structure, where all subsequent words in the expression are attached to the first one using the flat label. The assumption is that these expressions do not have any internal syntactic structure and that the structural annotation is in principle arbitrary. In practice, however, it is highly desirable to use a consistent annotation of all flat MWEs in all languages."
			,""
			, ""
			)
	, FLAT_FOREIGN(
			"flat:foreign"
			,"flat multiword foreign phrase"
			, "The flat relation, with the optional subtype flat:foreign should also be used when a foreign phrase cannot be given a compositional analysis."
			,""
			, ""
			)
	, FLAT_NAME(
			"flat:name"
			,"flat multiword proper name"
			, "In many languages, there are multiword proper names with no clear internal syntactic structure and no clear evidence that one of the words is the syntactic head. Such names are annotated using the flat relation, with the optional subtype flat:name. Titles/honorifics are also analyzed using the flat relation. Note that some titles are complex and have their own internal syntactic structure. Such structure is shown with regular relations embedded under flat. However if the two halves of a descriptive title and a name appear to be two separate nominals, then analysis with flat is not appropriate, and appos is appropriate. These cases are often set off by punctuation, such as a comma, but no punctuation may appear in more informal text. You can generally test for such examples by asking if the two halves can be reversed; if they can, it is probably an appos."
			,""
			, ""
			)
	, GOESWITH(
			"goeswith"
			,"goes with"
			,"This relation links two or more parts of a word that are separated in text that is not well edited. These parts should be written together as one word according to the ortographic rules of a given language. The head is always the first part, the other parts are attached to it with the goeswith relation (for consistency, similarly as in flat, fixed and conj). "
			,""
			, ""
			)
	, IOBJ(
			"iobj"
			,"indirect object"
			,"The indirect object of a verb is any nominal phrase that is a core argument of the verb but is not its subject or (direct) object. The prototypical example is the recipient of ditransitive verbs of exchange:, e.g. 'she gave me a raise' where raise is the iobj."
			,""
			, ""
			)
	, LIST(
			"list"
			,"list"
			,"The list relation is used for chains of comparable items. In lists with more than two items, all items of the list should modify the first one. Informal and web text often contains passages which are meant to be interpreted as lists but are parsed as single sentences. Email signatures often contain these structures, in the form of contact information: the different contact information items are labeled as list; the key-value pair relations are labeled as appos. However, list should not be over-used. If a construction can be easily analyzed using the grammatical relations of standard sentences, such as when there is overt coordination, then it should be analyzed with these more standard relations, even if it is laid out as a list typographically."
			,""
			, ""
			)
	, mark(
			"mark"
			,"marker"
			,"A marker is the word introducing a finite clause subordinate to another clause. For a complement clause, this is words like [en] that or whether. For an adverbial clause, the marker is typically a subordinating conjunction like [en] while or although. The mark is a dependent of the subordinate clause head. In a relative clause, it is a normally uninflected word, which simply introduces a relative clause, such as [he] še. (In this last use, one needs to distinguish between relative clause markers, which are mark from relative pronouns, which fill a regular verbal argument or modifier grammatical relation."
			,""
			, ""
			)
	, NMOD(
			"nmod"
			,"nominal modifier"
			,"The nmod relation is used for nominal dependents of another noun or noun phrase and functionally corresponds to an attribute, or genitive complement."
			,""
			, ""
			)
	, NSUBJ(
			"nsubj"
			,"nominal subject"
			,"A nominal subject (nsubj) is a nominal which is the syntactic subject and the proto-agent of a clause. That is, it is in the position that passes typical grammatical test for subjecthood, and this argument is the more agentive, the do-er, or the proto-agent of the clause. This nominal may be headed by a noun, or it may be a pronoun or relative pronoun or, in ellipsis contexts, other things such as an adjective. The nsubj relation is also used for the nominal subject of a passive verb or verb group, even though the subject is then not typically the proto-agent argument due to valency changing operations. For languages that have a grammaticalized passive transformation, it is strongly recommended to use the subtype nsubj:pass in such cases. The governor of the nsubj relation might not always be a verb: when the verb is a copular verb, the root of the clause is the complement of the copular verb, which can be an adjective or noun, including a noun marked by a preposition, as in the examples below.  The nsubj role is only applied to semantic arguments of a predicate. When there is an empty argument in a grammatical subject position (sometimes called a pleonastic or expletive), it is labeled as expl. If there is then a displaced subject in the clause, as in the English existential there construction, it will be labeled as nsubj.)"
			,""
			, ""
			)
	, NSUBJ_PASS(
			"nsubj:pass"
			,"nominal subject - passive"
			, ""
			,""
			, ""
			)
	, NUMMOD(
			"nummod"
			,"numeric modifier"
			,"A numeric modifier of a noun is any number phrase that serves to modify the meaning of the noun with a quantity. Note that indefinite quantifiers such as few, many are tagged DET rather than NUM. Therefore their relation to the quantified noun is not nummod but det:"
			,""
			, ""
			)
	, OBJ(
			"obj"
			,"object"
			,"The object of a verb is the second most core argument of a verb after the subject. Typically, it is the noun phrase that denotes the entity acted upon or which undergoes a change of state or motion (the proto-patient). In general, if there is just one object, it should be labeled obj, regardless of the morphological case or semantic role that it bears. If there are two or more objects, one of them should be obj and the others should be iobj. In such cases it is necessary to decide what is the most directly affected object (patient)."
			,""
			, ""
			)
	, OBL(
			"obl"
			,"oblique nominal"
			,"The obl relation is used for a nominal (noun, pronoun, noun phrase) functioning as a non-core (oblique) argument or adjunct. This means that it functionally corresponds to an adverbial attaching to a verb, adjective or other adverb. "
			,""
			, ""
			)
	, OBL_AGENT(
			"obl:agent"
			,"oblique nominal agent"
			, "An oblique that is the agent of a passive verb.  An optional subtype."
			,""
			, ""
			)
	, ORPHAN(
			"orphan"
			,"orphan"
			,"The ‘orphan’ relation is used in cases of head ellipsis where simple promotion would result in unnatural and misleading dependency relation. The typical case is predicate ellipsis where one of the core arguments have to be promoted to clausal head."
			,""
			, ""
			)
	, PARATAXIS(
			"parataxis"
			,"parataxis"
			,"The parataxis relation (from Greek for “place side by side”) is a relation between a word (often the main predicate of a sentence) and other elements, such as a sentential parenthetical or a clause after a “:” or a “;”, placed side by side without any explicit coordination, subordination, or argument relation with the head word. Parataxis is a discourse-like equivalent of coordination, and so usually obeys an iconic ordering. Hence it is normal for the first part of a sentence to be the head and the second part to be the parataxis dependent, regardless of the headedness properties of the language. But things do get more complicated, such as cases of parentheticals, which appear medially. The parataxis relation (from Greek for “place side by side”) is a relation between a word (often the main predicate of a sentence) and other elements, such as a sentential parenthetical or a clause after a “:” or a “;”, placed side by side without any explicit coordination, subordination, or argument relation with the head word. Parataxis is a discourse-like equivalent of coordination, and so usually obeys an iconic ordering. Hence it is normal for the first part of a sentence to be the head and the second part to be the parataxis dependent, regardless of the headedness properties of the language. But things do get more complicated, such as cases of parentheticals, which appear medially."
			,""
			, ""
			)
	, PUNCT(
			"punct"
			,"punctuation"
			,"This is used for any piece of punctuation in a clause, if punctuation is being retained in the typed dependencies."
			,""
			, ""
			)
	, REPARANDUM(
			"reparandum"
			,"reparandum (overridden disfluency)"
			,"We use reparandum to indicate disfluencies overridden in a speech repair. The disfluency is the dependent of the repair. For example 'Go to the righ- to the left.'  The word 'left' is the dependent of 'righ-' and labeled as reparandum."
			,""
			, ""
			)
	, ROOT(
			"root"
			,"root"
			,"The root grammatical relation points to the root of the sentence. A fake node ROOT is used as the governor. The ROOT node is indexed with 0, since the indexing of real words in the sentence starts at 1. (The ROOT node is not represented explicitly in CoNLL-U. But, it is in OLW.)"
			,""
			, ""
			)
	, VOCATIVE(
			"vocative"
			,"vocative"
			,"The vocative relation is used to mark a dialogue participant addressed in a text (common in conversations, dialogue, emails, newsgroup postings, etc.). The relation links the addressee’s name to its host sentence. A vocative commonly co-occurs with a null subject, as in the first example below. If the nominal is clearly vocative in intent, the preference is to use the vocative relation."
			,""
			, ""
			)
	, XCOMP(
			"xcomp"
			,"open clausal complement"
			,"An open clausal complement (xcomp) of a verb or an adjective is a predicative or clausal complement without its own subject. The reference of the subject is necessarily determined by an argument external to the xcomp (normally by the object of the next higher clause, if there is one, or else by the subject of the next higher clause). This is often referred to as obligatory control. These clauses tend to be non-finite in many languages, but they can be finite as well. The name xcomp is borrowed from Lexical-Functional Grammar. The xcomp relation is also used in constructions that are known as secondary predicates or predicatives. For example, 'She declared the cake beautiful.'  The word 'beautiful' is dependent on 'declared' and labeled as 'xcomp'. Note that the above condition “without its own subject” does not mean that a clause is an xcomp just because its subject is not overt. The subject must be necessarily inherited from a fixed position in the higher clause. That is, there should be no available interpretation where the subject of the lower clause may be distinct from the specified role of the upper clause. In cases where the missing subject may or must be distinct from a fixed role in the higher clause, ccomp should be used instead, as below. This includes cases of arbitrary subjects and anaphoric control."
			,""
			, ""
			)
	, TBD(
			"TBD"
			,"to-be-determined"
			,"to be explained"
			,"tbd"
			, ""
			)
	;
	public String keyname = "";
	public String fullname = "";
	public String decription = "";
	public String parse = "";
	public String gev = "";
	
	private UD_DEP_REL_LABEL(
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
	public static UD_DEP_REL_LABEL forName(String name) {
		for (UD_DEP_REL_LABEL v : UD_DEP_REL_LABEL.values()) {
			if (v.keyname.equals(name)) {
				return v;
			}
		}
		return UD_DEP_REL_LABEL.TBD;
	}
	
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (UD_DEP_REL_LABEL e : UD_DEP_REL_LABEL.values()) {
    		result.add(new DropdownItem(e.keyname + " - " + e.fullname, e.keyname).toJsonObject());
    	}
    	return result;
    }
    
    public static JsonArray toJsonArray() {
    	JsonArray result = new JsonArray();
    	for (UD_DEP_REL_LABEL e : UD_DEP_REL_LABEL.values()) {
    		JsonObject entry = new JsonObject();
    		entry.addProperty("key", e.keyname);
    		entry.addProperty("value", e.fullname);
    		result.add(entry);
    	}
    	return result;
    }

}
