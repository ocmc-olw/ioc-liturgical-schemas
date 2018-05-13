package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.AnimalCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.BeingCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.ConceptCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.EventCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.GodCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.GroupCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.HumanCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToAnimalCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToBeingCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToBiblicalTextCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToConceptCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToEventCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToGodCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToGroupCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToHumanCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToMysteryCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToObjectCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToPlaceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToPlantCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToRoleCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.MysteryCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.ObjectCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.PlaceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.PlantCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.RoleCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TextBiblicalSourceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TextBiblicalTranslationCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TextLiturgicalSourceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TextLiturgicalTranslationCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TextNoteCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TokenAnalysisCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.UserNoteCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.template.TemplateConfig;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.ConcordanceLine;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.PtbSentence;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.PtbWord;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.TokenAnalysis;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.WordAnalysis;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.WordInflected;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.notes.TextualNote;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.notes.UserNote;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Animal;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Being;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Concept;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Event;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.God;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Group;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Human;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Mystery;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Object;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Place;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Plant;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Role;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.TextBiblical;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.TextLiturgical;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.tables.ReactBootstrapTableData;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.Section;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.Template;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.TemplateNode;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToAnimal;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToBeing;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToBiblicalText;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToConcept;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToEvent;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToGod;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToGroup;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToHuman;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToMystery;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToObject;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToPlace;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToPlant;
import org.ocmc.ioc.liturgical.schemas.models.db.links.LinkRefersToRole;
import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTK;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbNote;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbTokenAnalysis;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGenerationUnit;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink;
import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;
import org.ocmc.ioc.liturgical.schemas.models.ModelHelpers;
import org.ocmc.ioc.liturgical.schemas.models.abbreviations.Abbreviation;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.*;

/**
 * Enumerates classes that have schemas for storing in the database
 * @author mac002
 *
 */
public enum SCHEMA_CLASSES {
	ABBREVIATION(
			new Abbreviation(" "," ", " ")
			, new Abbreviation(" "," ", " ")
			, "Abbreviation"
			)
	, ANIMAL(
			new AnimalCreateForm(" ")
			, new Animal(" ")
			, "Animal"
			)
	, BEING(
			new BeingCreateForm(" ")
			, new Being(" ")
			, "Being"
			)
	, BibEntryArticle(
	new BibEntryArticle(" "," ")
	, new BibEntryArticle(" "," ")
	, "Article"
	)
	, BibEntryBook(
	new BibEntryBook(" "," ")
	, new BibEntryBook(" "," ")
	, "Book"
	)
	, BibEntryMvbook(
	new BibEntryMvbook(" "," ")
	, new BibEntryMvbook(" "," ")
	, "Multi-Volume Book"
	)
	, BibEntryInbook(
	new BibEntryInbook(" "," ")
	, new BibEntryInbook(" "," ")
	, "In Book"
	)
	, BibEntryBookinbook(
	new BibEntryBookinbook(" "," ")
	, new BibEntryBookinbook(" "," ")
	, "Book in Book"
	)
	, BibEntrySuppbook(
	new BibEntrySuppbook(" "," ")
	, new BibEntrySuppbook(" "," ")
	, "Book Supplement"
	)
	, BibEntryBooklet(
	new BibEntryBooklet(" "," ")
	, new BibEntryBooklet(" "," ")
	, "Booklet"
	)
	, BibEntryCollection(
	new BibEntryCollection(" "," ")
	, new BibEntryCollection(" "," ")
	, "Collection"
	)
	, BibEntryMvcollection(
	new BibEntryMvcollection(" "," ")
	, new BibEntryMvcollection(" "," ")
	, "Multi-Volume Collection"
	)
	, BibEntryIncollection(
	new BibEntryIncollection(" "," ")
	, new BibEntryIncollection(" "," ")
	, "In Collection"
	)
	, BibEntrySuppcollection(
	new BibEntrySuppcollection(" "," ")
	, new BibEntrySuppcollection(" "," ")
	, "Collection Supplement"
	)
	, BibEntryManual(
	new BibEntryManual(" "," ")
	, new BibEntryManual(" "," ")
	, "Manual"
	)
	, BibEntryMisc(
	new BibEntryMisc(" "," ")
	, new BibEntryMisc(" "," ")
	, "Miscellaneous"
	)
	, BibEntryOnline(
	new BibEntryOnline(" "," ")
	, new BibEntryOnline(" "," ")
	, "Online (web, or Internet)"
	)
	, BibEntryPatent(
	new BibEntryPatent(" "," ")
	, new BibEntryPatent(" "," ")
	, "Patent"
	)
	, BibEntryPeriodical(
	new BibEntryPeriodical(" "," ")
	, new BibEntryPeriodical(" "," ")
	, "Periodical"
	)
	, BibEntrySuppperiodical(
	new BibEntrySuppperiodical(" "," ")
	, new BibEntrySuppperiodical(" "," ")
	, "Periodical Supplement"
	)
	, BibEntryProceedings(
	new BibEntryProceedings(" "," ")
	, new BibEntryProceedings(" "," ")
	, "Proceedings"
	)
	, BibEntryMvproceedings(
	new BibEntryMvproceedings(" "," ")
	, new BibEntryMvproceedings(" "," ")
	, "Multi-Volume Proceedings"
	)
	, BibEntryInproceedings(
	new BibEntryInproceedings(" "," ")
	, new BibEntryInproceedings(" "," ")
	, "In Proceedings"
	)
	, BibEntryReference(
	new BibEntryReference(" "," ")
	, new BibEntryReference(" "," ")
	, "Reference"
	)
	, BibEntryMvreference(
	new BibEntryMvreference(" "," ")
	, new BibEntryMvreference(" "," ")
	, "Multi-Volume Reference"
	)
	, BibEntryInreference(
	new BibEntryInreference(" "," ")
	, new BibEntryInreference(" "," ")
	, "In Reference"
	)
	, BibEntryReport(
	new BibEntryReport(" "," ")
	, new BibEntryReport(" "," ")
	, "Report"
	)
	, BibEntryThesis(
	new BibEntryThesis(" "," ")
	, new BibEntryThesis(" "," ")
	, "Thesis"
	)
	, BibEntryUnpublished(
	new BibEntryUnpublished(" "," ")
	, new BibEntryUnpublished(" "," ")
	, "Unpublished"
	)
	, CONCORDANCE_LINE(
			new ConcordanceLine(" ",0,0," "," "," ")
			, new ConcordanceLine(" ",0,0," "," "," ")
			, "Concordance Line"
			)
	, CONCEPT(
			new ConceptCreateForm(" ")
			, new Concept(" ")
			, "Concept"
			)
	, EVENT(
			new EventCreateForm(" ")
			, new Event(" ")
			, "Event"
			)
	, GOD(
			new GodCreateForm(" ")
			, new God(" ")
			, "God"
			)
	, GROUP(
			new GroupCreateForm(" ")
			, new Group(" ")
			, "Group"
			)
	, HUMAN(
			new HumanCreateForm(" ")
			, new Human(" ")
			, "Human"
			)
	, LEXICAL_FORM(
			new WordInflected("", 0)
			, new WordInflected("", 0)
			, "Lexical Form"
			)
	, LINK_REFERS_TO_ANIMAL(
			new LinkRefersToAnimalCreateForm(" "," ","")
			, new LinkRefersToAnimal(" "," ","")
			, "Reference to Animal"
			)
	, LINK_REFERS_TO_BEING(
			new LinkRefersToBeingCreateForm(" "," ","")
			, new LinkRefersToBeing(" "," ","")
			, "Reference to Being"
			)
	, LINK_REFERS_TO_BIBLICAL_TEXT(
			new LinkRefersToBiblicalTextCreateForm(" "," ","")
			, new LinkRefersToBiblicalText(" "," ","")
			, "Reference to Biblical Text"
			)
	, LINK_REFERS_TO_CONCEPT(
			new LinkRefersToConceptCreateForm(" "," ","")
			, new LinkRefersToConcept(" "," ","")
			, "Reference to Concept"
			)
	, LINK_REFERS_TO_EVENT(
			new LinkRefersToEventCreateForm(" "," ","")
			, new LinkRefersToEvent(" "," ","")
			, "Reference to Event"
			)
	, LINK_REFERS_TO_GOD(
			new LinkRefersToGodCreateForm(" "," ","")
			, new LinkRefersToGod(" "," ","")
			, "Reference to God"
			)
	, LINK_REFERS_TO_GROUP(
			new LinkRefersToGroupCreateForm(" "," ","")
			, new LinkRefersToGroup(" "," ","")
			, "Reference to Group"
			)
	, LINK_REFERS_TO_HUMAN(
			new LinkRefersToHumanCreateForm(" "," ","")
			, new LinkRefersToHuman(" "," ","")
			, "Reference to Human"
			)
	, LINK_REFERS_TO_MYSTERY(
			new LinkRefersToMysteryCreateForm(" "," ","")
			, new LinkRefersToMystery(" "," ","")
			, "Reference to Mystery"
			)
	, LINK_REFERS_TO_OBJECT(
			new LinkRefersToObjectCreateForm(" "," ","")
			, new LinkRefersToObject(" "," ","")
			, "Reference to Object"
			)
	, LINK_REFERS_TO_PLACE(
			new LinkRefersToPlaceCreateForm(" "," ","")
			, new LinkRefersToPlace(" "," ","")
			, "Reference to Place"
			)
	, LINK_REFERS_TO_PLANT(
			new LinkRefersToPlantCreateForm(" "," ","")
			, new LinkRefersToPlant(" "," ","")
			, "Reference to Plant"
			)
	, LINK_REFERS_TO_ROLE(
			new LinkRefersToRoleCreateForm(" "," ","")
			, new LinkRefersToRole(" "," ","")
			, "Reference to Role"
			)
	, MYSTERY(
			new MysteryCreateForm(" ")
			, new Mystery(" ")
			, "Reference to Mystery"
			)
	, NOTE_TEXTUAL(
			new TextNoteCreateForm(" "," ","")
			, new TextualNote(" "," ","")
			, "Note about a Text"
			)
	, NOTE_USER(
			new UserNoteCreateForm(" "," ","")
			, new UserNote(" "," ","")
			, "Personal Note"
			)
	, OBJECT(
			new ObjectCreateForm(" ")
			, new Object(" ")
			, "Object"
			)
	, WORD_ANALYSIS(
			new WordAnalysis()
			, new WordAnalysis()
			, "Word Analysis"
			)
	, PERSEUS_TREEBANK_SENTENCE(
			new PtbSentence("","0")
			, new PtbSentence("","0")
			, "Perseus Treebank Sentence"
			)
	, PERSEUS_TREEBANK_WORD(
			new PtbWord("","0")
			, new PtbWord("","0")
			, "Perseus Treebank Word"
			)
	, PLACE(
			new PlaceCreateForm(" ")
			, new Place(" ")
			, "Place"
			)
	, PLANT(
			new PlantCreateForm(" ")
			, new Plant(" ")
			, "Plant"
		)
	, ROLE(
			new RoleCreateForm(" ")
			, new Role(" ")
			, "Role"
			)
	, SECTION(
			new Section(" ", "", "")
			, new Section(" ", "", "")
			, "Section"
			)
	, TABLE_DATA_FOR_REACT_BOOTSTRAP(
			new ReactBootstrapTableData(TOPICS.TABLES_ROOT, "")
			, new ReactBootstrapTableData(TOPICS.TABLES_ROOT,"")
			, "Table Data for React Bootstrap"
			)
	, TEMPLATE(
			new Template(" ", "")
			, new Template(" ", "")
			, "Template"
			)
	, TEXT_BIBLICAL_SOURCE(
			new TextBiblicalSourceCreateForm(" "," ", " ")
			, new TextBiblical(" "," ", " ")
			, "Biblical Source Text"
			)
	, TEXT_BIBLICAL_TRANSLATION(
			new TextBiblicalTranslationCreateForm(" "," ", " ")
			, new TextBiblical(" "," ", " ")
			, "Translation of Biblical Source Text"
			)
	, TEXT_LITURGICAL_SOURCE(
			new TextLiturgicalSourceCreateForm(" "," ", " ")
			, new TextLiturgical(" "," ", " ")
			, "Liturgical Source Text"
			)
	, TEXT_LITURGICAL_TRANSLATION(
			new TextLiturgicalTranslationCreateForm(" "," ", " ")
			, new TextLiturgical(" "," ", " ")
			, "Translation of Liturgical Source Text"
			)
	, TREE_NODE(
			new TokenAnalysisCreateForm("","0")
			, new TokenAnalysis("","0")
			, "Token Analysis"
			)
	;

	public LTK ltk;
	public LTKDb ltkDb;
	public String label = "";
	
	private static Gson gson = new Gson();
	
	/**
	 * 
	 * @param ltk  - used as the CreateForm supertype
	 * @param ltkDb - used as the database supertype
	 * @param referenceType - the type of relationship
	 */
	private SCHEMA_CLASSES(
			 LTK ltk
			 , LTKDb ltkDb
			 , String label
			) {
		this.ltk = ltk;
		this.ltkDb = ltkDb;
		this.label = label;
	}

	/**
	 * Gets the LTK for this schema, whether the schema name provided is for the LTK or the LTKDb
	 * @param name of the schema
	 * @return the LTK for that schema
	 */
	public static LTK ltkForSchemaName(String name) {
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltk.schemaIdAsString().equals(name) || s.ltkDb.schemaIdAsString().equals(name)) {
				return s.ltk;
			}
		}
		return null;
	}
	
	/**
	 * Gets the LTKDb for this schema, whether the schema name provided is for the LTK or the LTKDb
	 * @param name of the schema
	 * @return the LTKDb for that schema
	 */
	public static LTKDb ltkDbForSchemaName(String name) {
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltk.schemaIdAsString().equals(name) || s.ltkDb.schemaIdAsString().equals(name)) {
				return s.ltkDb;
			}
		}
		return null;
	}
	/**
	 * Validate the json using this schema.
	 * The method will test the schema to see if it is
	 * an LTK or LTKDb and use the appropriate class.
	 * @param json to validate
	 * @return results of the validation.  It's length will be zero if there are no problems.
	 */
	public static String validate(String json) {
		String result = "";
		SCHEMA_CLASSES theClass = null;
		String schema = "";
		try {
			LTK ltk = gson.fromJson(json, LTK.class);
			schema = ltk.get_valueSchemaId();
			 theClass = classForSchemaName(schema);
				if (ltk.get_valueSchemaId().contains("CreateForm")) {
					result = theClass.ltk.validate(json);
				} else {
					result = theClass.ltkDb.validate(json);
				}
		} catch (Exception e) {
			if (theClass == null) {
				System.out.println("SCHEMA_CLASSES does not include " + schema);
			}
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Validate the json using this ltk schema
	 * @param json to validate
	 * @return results of the validation.  It's length will be zero if there are no problems.
	 */
	public String validateLtk(String json) {
		this.ltk.validate(json);
		return "";
	}
	
	/**
	 * Validate the json using this ltkDb schema
	 * @param json to validate
	 * @return results of the validation.  It's length will be zero if there are no problems.
	 */
	public String validateLtkDb(String json) {
		this.ltkDb.validate(json);
		return "";
	}

	/**
	 * Is the json for this class for a CreateForm?
	 * @param json to check
	 * @return true if the json for this class is a CreateForm
	 */
	public static boolean classIsCreateForm(String json) {
		boolean result = false;
		try {
			LTK ltk = gson.fromJson(json, LTK.class);
			result = ltk.get_valueSchemaId().toLowerCase().contains("createform");
		} catch (Exception e) {
			result = false;
		}
		return result;
	}
	
	public static SCHEMA_CLASSES classForSchemaName(String name) {
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltk.schemaIdAsString().equals(name) || s.ltkDb.schemaIdAsString().equals(name)) {
				return s;
			}
		}
		return null;
	}
	
	public LTK getLtkFromJson(String json) {
		LTK result = null;
		try {
			result = gson.fromJson(
					json
					, this.ltk.getClass())
			;
		} catch (Exception e) {
			result = null;
		}
		return result;
	}
	
	/**
	 * Get a list of the relationship types used by the Schema classes
	 * @return a list of the relationship types used by the Schema classes
	 */
	public static List<RELATIONSHIP_TYPES> getRelationshipTypes() {
		List<RELATIONSHIP_TYPES> result = new ArrayList<RELATIONSHIP_TYPES>();
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink) {
				LTKLink link = (LTKLink) s.ltkDb;
				if (! result.contains(link.getType())) {
					result.add(link.getType());
				}
			}
		}
		return result;
	}

	/**
	 * Get a map where:
	 *    relationship typename is the key
	 *    value is a list of properties used for that relationship type
	 * @return map where relationship typename is the key and value is a list of props for that type
	 */
	public static Map<String,List<String>> relationshipPropertyMap() {
		Map<String, List<String>> result = new TreeMap<String,List<String>>();
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink) {
				LTKLink link = (LTKLink) s.ltkDb;
					result.put(
							link.getType().typename
							, ModelHelpers.getPropertiesList(link)
							);
			}
		}
		return result;
	}

	/**
	 * Creates a Json Object with keys that are the typename and
	 * values that are a JsonArray of the property names for the
	 * schema assocated with that typename.
	 * @return a JsonObject with keys that are the typename an values are a JsonArray of the prop names
	 */
	public static JsonObject ontologyPropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry) {
				LTKDbOntologyEntry entry = (LTKDbOntologyEntry) s.ltkDb;
				result.add(
						entry.getTopic()
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}

	/**
	 * Creates a Json Object with keys that are the typename and
	 * values that are a JsonArray of the property names for the
	 * schema assocated with that typename.
	 * @return JsonObject with keys that are the typename and prop names as a JsonArray
	 */
	public static JsonObject notePropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbNote) {
				LTKDbNote entry = (LTKDbNote) s.ltkDb;
				result.add(
						entry.getOntologyTopic().label
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}

	public static JsonObject abbreviationPropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.abbreviations.Abbreviation) {
				Abbreviation entry = (Abbreviation) s.ltkDb;
				result.add(
						entry.getOntologyTopic().label
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}
	public static JsonObject bibliographyPropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry) {
				BibliographyEntry entry = (BibliographyEntry) s.ltkDb;
				result.add(
						entry.getOntologyTopic().label
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}
	public static JsonArray noteTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbNote) {
				LTKDbNote entry = (LTKDbNote) s.ltkDb;
				result.add(new DropdownItem(entry.getOntologyTopic().label).toJsonObject());
			}
		}
		return result;
	}

	public static JsonArray bibliographyTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any", TOPICS.BIBLIOGRAPHY.label).toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry) {
				BibliographyEntry entry = (BibliographyEntry) s.ltkDb;
				result.add(new DropdownItem(s.label, entry.toSchemaAsLabel()).toJsonObject());
			}
		}
		return result;
	}

	public static JsonArray abbreviationTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.abbreviations.Abbreviation) {
				Abbreviation entry = (Abbreviation) s.ltkDb;
				result.add(new DropdownItem(entry.toSchemaAsLabel(), entry.getOntologyTopic().label).toJsonObject());
			}
		}
		return result;
	}

	/**
	 * Creates a Json Object with keys that are the typename and
	 * values that are a JsonArray of the property names for the
	 * schema assocated with that typename.
	 * @return JsonObject with keys that are the typename and prop names as a JsonArray
	 */
	public static JsonObject templatePropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGenerationUnit) {
				LTKDbGenerationUnit entry = (LTKDbGenerationUnit) s.ltkDb;
				result.add(
						entry.getOntologyTopic().label
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}

	public static JsonArray templateTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGenerationUnit) {
				LTKDbGenerationUnit entry = (LTKDbGenerationUnit) s.ltkDb;
				result.add(new DropdownItem(entry.getOntologyTopic().label).toJsonObject());
			}
		}
		return result;
	}

	/**
	 * Creates a Json Object with keys that are the typename and
	 * values that are a JsonArray of the property names for the
	 * schema assocated with that typename.
	 * @return a JsonObject with keys that are typenames and JsonArrays that are prop names
	 */
	public static JsonObject tokenAnalysisPropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbTokenAnalysis) {
				LTKDbTokenAnalysis entry = (LTKDbTokenAnalysis) s.ltkDb;
				result.add(
						entry.getOntologyTopic().label
						, ModelHelpers.getPropertiesAsDropdownItems(entry)
				);
			}
		}
		return result;
	}

	public static JsonArray tokenAnalysisTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbTokenAnalysis) {
				LTKDbTokenAnalysis entry = (LTKDbTokenAnalysis) s.ltkDb;
				result.add(new DropdownItem(entry.getOntologyTopic().label).toJsonObject());
			}
		}
		return result;
	}

	public static JsonArray ontologyTypesJson() {
		JsonArray result = new JsonArray();
		result.add(new DropdownItem("Any","*").toJsonObject());
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry) {
				LTKDbOntologyEntry entry = (LTKDbOntologyEntry) s.ltkDb;
				result.add(new DropdownItem(entry.getTopic()).toJsonObject());
			}
		}
		return result;
	}

	/**
	 * Creates a Json Object with keys that are the typename and
	 * values that are a JsonArray of the property names for the
	 * schema associated with that typename.
	 * @return JsonObject with keys that are the typename and prop names as a JsonArray
	 */
	public static JsonObject relationshipPropertyJson() {
		JsonObject result = new JsonObject();
		JsonArray anyProps = new JsonArray();
		anyProps.add(new DropdownItem("Any","*").toJsonObject());
		anyProps.add(new DropdownItem("id","id").toJsonObject());
		result.add("*", anyProps);
		for (SCHEMA_CLASSES s : SCHEMA_CLASSES.values()) {
			if (s.ltkDb instanceof org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink) {
				LTKLink link = (LTKLink) s.ltkDb;
				result.add(
						link.getType().typename
						, ModelHelpers.getPropertiesAsDropdownItems(link)
				);
			}
		}
		return result;
	}


}
