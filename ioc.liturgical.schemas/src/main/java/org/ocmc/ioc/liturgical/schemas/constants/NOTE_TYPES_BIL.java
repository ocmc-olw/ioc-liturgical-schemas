package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 *
 * Note Types of the Bible in Liturgy Project (Fr. Eugen Pentiuc)
 * 
 * @author mac002
 *
 */
public enum NOTE_TYPES_BIL {

PERICOPE("PERI","Pericope")
, LEMMA("LEMMA","Lemma")
//, ANCIENT_TEXTS("TNAT","Ancient Texts")
//, BIBLICAL_INTERTEXTUALITY("TNBI","Biblical Intertextuality")
//, CHRISTIAN_TRADITION_PATRISTIC_COMMENTARTIES("TNCTPC","Christian Tradition - Patristic Commentaries")
//, CHRISTIAN_TRADITION_THEOLOGICAL_WORKS("TNCTTW","Christian Tradition - Theological Works")
//, CHRISTIAN_TRADITION_HAPGIOGRAPHA("TNCTH","Christian Tradition - Hagiographa")
//, COMPARISON_OF_VERSIONS("TNCOV","Comparison of Versions")
//, EXEGETICAL("TNEXE","Exegetical")
//, GENERAL("TNGEN","General")
//, GEOGRAPHY("TNGEO","Geography")
//, GRAMMAR("TNLINGGRAM","Grammar")
//, HISTORY("TNH","History")
//, ISLAM("TNI","Islam")
//, JEWISH_TRADITION("TNJT","Jewish Tradition")
//, LAW("TNL","Law")
//, LITERARY_DEVICES("TNLD","Literary Devices")	
//, LITERARY_GENRE("TNLG","Literary Genre")
//, LITERATURE("TNLIT","Literature")
//, LITURGICAL_HOMILY("TNLITURGYHOMILY","Liturgical - Homily")
//, LITURGICAL_RUBRIC("TNLITURGYRUBRIC","Liturgical - Rubric")
//, LITURGICAL_USAGE("TNLITURGYUSE","Liturgical - Usage")
//, LITURGIES("TNLITURGY","Liturgies")
//, MUSIC("TNMU","Music")
//, MYSTICISM("TNMY","Mysticism")
//, PERITESTMENTAL_LITERATURE("TNPL","Peritestamental Literature")
//, PHILOSOPHY("TNPHILO","Philosophy")
//, MEANING_PLAIN("TNMP","Meaning - Plain")
//, MEANING_ALLEGORICAL("TNMA","Meaning - Allegorical")
//, MEANING_TYPOLOGICAL("TNMT","Meaning - Typological")
//, MEANING_ANAGOGICAL("TNMS","Meaning - Anagogical")
//, PSYCHOLOGY("TNPSY","Psychology")
, REF_TO_BIBLE("TNONTOBIBLE", "Reference - to Bible")
//, SUGGESTIONS_FOR_READING("TNSFR","Suggestions for Reading") 
//, SYNOPTIC_READING("TNSR","Synoptic Reading")
//, TEXT_WITNESS("TNTC","Text Witness")
//, TEXTUAL_CRITICISM("TNTC","Textual Criticism") 
//, THEOLOGY("TNTHEO","Theology")
//, VOCABULARY("TNV","Vocabulary")
;

	public String keyname = "";
	public String fullname = "";
	
	private NOTE_TYPES_BIL(
			String keyname
			, String fullname
			) {
		this.keyname = keyname;
		this.fullname = fullname;
	}

	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @param includeAny if true will add to the top an object that is value=*, label=any
	 * @return a JsonArray of Dropdowns 
	 */
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (NOTE_TYPES_BIL e : NOTE_TYPES_BIL.values()) {
    		result.add(new DropdownItem(e.fullname, e.name()).toJsonObject());
    	}
    	return result;
    }

	/**
	 * Converts the enumeration a List of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return a list of dropdowns
	 */
    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (NOTE_TYPES_BIL e : NOTE_TYPES_BIL.values()) {
    		result.add(new DropdownItem(e.fullname, e.name()));
    	}
    	return result;
    }
		
}
