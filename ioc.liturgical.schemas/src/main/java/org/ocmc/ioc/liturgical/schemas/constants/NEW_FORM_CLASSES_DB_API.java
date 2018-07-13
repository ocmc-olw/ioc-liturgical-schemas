package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.schemas.models.supers.BibliographyEntry;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.WsPaths;
import org.ocmc.ioc.liturgical.schemas.models.abbreviations.Abbreviation;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryArticle;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryBook;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryBookinbook;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryBooklet;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryCollection;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryInbook;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryIncollection;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryInproceedings;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryInreference;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryManual;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryMisc;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryMvbook;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryMvcollection;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryMvproceedings;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryMvreference;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryOnline;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryPatent;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryPeriodical;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryProceedings;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryReference;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryReport;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntrySuppbook;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntrySuppcollection;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntrySuppperiodical;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryThesis;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryUnpublished;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.ConcordanceLine;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.WordAnalysis;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.notes.TextualNote;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.Section;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.Template;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.TemplateNode;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.AnimalCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.BeingCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.ConceptCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.EventCreateForm;
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
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.TokenAnalysisCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.UserNoteCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.labels.UiLabel;

/**
 * Enumerates classes that are a form for creating a new doc.
 * 
 *  The restriction filters are applied by the WsDatastoreManager.getNewDocForms() method
 *  when a forms list is requested by a user.  
 *  
 *  If the form restriction is WS_ADMIN,
 * then only a user that is a web service admin is allowed to use it.
 * 
 * If it is restricted to NONE, then only someone with
 * that authorization or higher (i.e. a WS_ADMIN) can use it.
 * 
 * If it is restricted to DOMAIN_ADMIN, then only someone with that
 * authorization or higher (i.e. NONE, WS_ADMIN) can use it.
 * 
 * 
 * @author mac002
 *
 */
public enum NEW_FORM_CLASSES_DB_API {
	ABBREVIATION(
			"Abbreviation"
			, new Abbreviation(" "," ", " ")
			, ENDPOINTS_DB_API.DOCS
			, RESTRICTION_FILTERS.NONE
			, false
			, true
			)
,	NEW_ANIMAL(
			"Animal (Ontology)"
			, new AnimalCreateForm("")
			, ENDPOINTS_DB_API.DOCS
			, RESTRICTION_FILTERS.DOMAIN_AUTHOR
			, true
			, true
			)
,	NEW_LINK_REFERS_TO_ANIMAL(
			"doc refers animal"
			, new LinkRefersToAnimalCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			, false
			, false
			)
,	NEW_BEING(
		"Being (Ontology)"
		, new BeingCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
,	NEW_LINK_REFERS_TO_BEING(
			"doc refers to being"
			, new LinkRefersToBeingCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			, false
			, false
			)
,	NEW_LINK_REFERS_TO_BIBLICAL_TEXT(
			"doc refers to biblical text"
			, new LinkRefersToBiblicalTextCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			, false
			, false
			)
,	NEW_BIBENTRY_ARTICLE(
		"Article (Bibliography Entry)"
		, new BibEntryArticle("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_BOOK(
		"Book (Bibliography Entry)"
		, new BibEntryBook("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_BOOK_IN_BOOK(
		"Book in Book (Bibliography Entry)"
		, new BibEntryBookinbook("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_BOOKLET(
		"Booklet (Bibliography Entry)"
		, new BibEntryBooklet("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_COLLECTION(
		"Collection (Bibliography Entry)"
		, new BibEntryCollection("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_INBOOK(
		"In Book (Bibliography Entry)"
		, new BibEntryInbook("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_INCOLLECTION(
		"In Collection (Bibliography Entry)"
		, new BibEntryIncollection("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_INPROCEEDINGS(
		"In Proceedings (Bibliography Entry)"
		, new BibEntryInproceedings("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_INREFERENCE(
		"In Reference (Bibliography Entry)"
		, new BibEntryInreference("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MANUAL(
		"Manual (Bibliography Entry)"
		, new BibEntryManual("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MISC(
		"Micsellaneous (Bibliography Entry)"
		, new BibEntryMisc("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MVBOOK(
		"Multi-Volume Book (Bibliography Entry)"
		, new BibEntryMvbook("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MVCOLLECTION(
		"Multi-Volume Collection (Bibliography Entry)"
		, new BibEntryMvcollection("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MVPROCEEDINGS(
		"Multi-Volume Proceedings (Bibliography Entry)"
		, new BibEntryMvproceedings("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_MVREFERENCE(
		"Multi-Volume Reference (Bibliography Entry)"
		, new BibEntryMvreference("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_ONLINE(
		"Online (Bibliography Entry)"
		, new BibEntryOnline("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_PATENT(
		"Patent (Bibliography Entry)"
		, new BibEntryPatent("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_PERIODICAL(
		"Periodical (Bibliography Entry)"
		, new BibEntryPeriodical("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_PROCEEDINGS(
		"Proceedings (Bibliography Entry)"
		, new BibEntryProceedings("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_REFERENCE(
		"Reference (Bibliography Entry)"
		, new BibEntryReference("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_REPORT(
		"Report (Bibliography Entry)"
		, new BibEntryReport("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_SUPPBOOK(
		"Book Supplement (Bibliography Entry)"
		, new BibEntrySuppbook("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_SUPPCOLLECTION(
		"Collection Supplement (Bibliography Entry)"
		, new BibEntrySuppcollection("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_SUPPPERIODICAL(
		"Periodical Supplement (Bibliography Entry)"
		, new BibEntrySuppperiodical("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_THESIS(
		"Thesis (Bibliography Entry)"
		, new BibEntryThesis("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
,	NEW_BIBENTRY_UNPUBLISHED(
		"Unpublished (Bibliography Entry)"
		, new BibEntryUnpublished("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, true
		)
, NEW_CONCEPT(
		"Concept (Ontology)"
		, new ConceptCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_CONCORDANCE_LINE(
		"ConcordanceLine"
		, new ConcordanceLine(" ",0,0," "," "," ")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_LINK_REFERS_TO_CONCEPT(
		"doc refers to concept"
		, new LinkRefersToConceptCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_EVENT(
		"Event (Ontology)"
		, new EventCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_EVENT(
		"doc refers to event"
		, new LinkRefersToEventCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_LINK_REFERS_TO_GOD(
		"doc refers to God"
		, new LinkRefersToGodCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_GROUP(
		"Group (Ontology)"
		, new GroupCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_GROUP(
		"doc refers to group"
		, new LinkRefersToGroupCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_HUMAN(
		"Human (Ontology)"
		, new HumanCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_HUMAN(
		"doc refers to human"
		, new LinkRefersToHumanCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_MYSTERY(
		"Mystery (Ontology)"
		, new MysteryCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_MYSTERY(
		"doc refers to mystery"
		, new LinkRefersToMysteryCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_NOTE_TEXTUAL(
		"Note (textual)"
		, new TextualNote(" ", " ", " ")
		, ENDPOINTS_DB_API.NOTES
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_NOTE_USER(
		"Note (private)"
		, new UserNoteCreateForm(" ", " ", " ")
		, ENDPOINTS_DB_API.NOTES
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_OBJECT(
		"Object (Ontology)"
		, new ObjectCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_OBJECT(
		"doc refers to object"
		, new LinkRefersToObjectCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_WORD_ANALYSIS(
		"Word Analysis"
		, new WordAnalysis()
		, ENDPOINTS_DB_API.WORD_ANALYSIS
		, RESTRICTION_FILTERS.WS_ADMIN
		, false
		, false
		)
, NEW_PLACE(
		"Place (Ontology)"
		, new PlaceCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_TEMPLATE(
		"Template"
		, new Template("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
//, NEW_TEMPLATE_NODE(
//		"TemplateNode"
//		, new TemplateNode()
//		, ENDPOINTS_DB_API.DOCS
//		, RESTRICTION_FILTERS.NONE
//		)
, NEW_SECTION(
		"Section"
		, new Section("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_LINK_REFERS_TO_PLACE(
		"doc refers to place"
		, new LinkRefersToPlaceCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_PLANT(
		"Plant (Ontology)"
		, new PlantCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_PLANT(
		"doc refers to plant"
		, new LinkRefersToPlantCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_ROLE(
		"Role (Ontology)"
		, new RoleCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.DOMAIN_AUTHOR
		, true
		, true
		)
, NEW_LINK_REFERS_TO_ROLE(
		"doc refers to role"
		, new LinkRefersToRoleCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_TEXT_BIBLICAL_SOURCE(
		"Biblical Text (Source)"
		, new TextBiblicalSourceCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_TEXT_BIBLICAL_TRANSLATION(
		"Biblical Text (Translation)"
		, new TextBiblicalTranslationCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_TEXT_LITURGICAL_TRANSLATION(
		"Liturgical Text (Translation)"
		, new TextLiturgicalTranslationCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_TEXT_LITURGICAL_SOURCE(
		"Liturgical Text (Source)"
		, new TextLiturgicalSourceCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
, NEW_TOKEN_ANALYSIS(
		"Token Analysis"
		, new TokenAnalysisCreateForm("","")
		, ENDPOINTS_DB_API.TOKEN_ANALYSIS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
	, NEW_UI_LABEL(
		"uilabel"
		, new UiLabel(" "," ", " ", " ")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		, false
		, false
		)
	;

	public AbstractModel obj;
	public ENDPOINTS_DB_API endpoint;
	public String name;
	public RESTRICTION_FILTERS restriction;
	public boolean pureOntology;
	public boolean includeForSchemaEditor;
	
	/**
	 * 
	 * @param name of the form
	 * @param obj an instance of the form
	 * @param endpoint that is used with this form
	 * @param restriction what type of role is allowed to use this form
	 */
	private NEW_FORM_CLASSES_DB_API(
			String name
			 , AbstractModel obj
			 , ENDPOINTS_DB_API endpoint
			 , RESTRICTION_FILTERS restriction
			 , boolean pureOntology
			 , boolean includeForSchemaEditor
			) {
		this.name = name;
		this.obj = obj;
		this.endpoint = endpoint;
		this.restriction = restriction;
		this.pureOntology = pureOntology;
		this.includeForSchemaEditor = includeForSchemaEditor;
	}
	
	public WsPaths toEndpointPaths() {
		WsPaths result = new WsPaths();
		result.setGet(this.toGetPath());
		result.setPost(this.toPostPath());
		result.setPut(this.toPutPath());
		return result;
	}
	
	/**
	 * Get the path to use for handling an http get
	 * @return the path to use for handling an http get
	 */
	public String toGetPath() {
		return this.endpoint.pathname;
	}
	/**
	 * Get the path to use for handling an http post
	 * @return path to use for handling an http post
	 */
	public String toPostPath() {
		return this.endpoint.pathname;
	}
	/**
	 * Get the path to use for handling an http put
	 * @return path to use for handling an http put
	 */
	public String toPutPath() {
		return this.endpoint.toLibraryTopicKeyPath();
	}
	
	/**
	 * 
	 * @param class1 for which to get endpoint paths
	 * @return the endpoint paths
	 */
	public static WsPaths getEndpointPathsForAbstractModel(Class<? extends AbstractModel> class1) {
		WsPaths result = new WsPaths();
		for (NEW_FORM_CLASSES_DB_API f : NEW_FORM_CLASSES_DB_API.values()) {
			if (f.obj.getClass().equals(class1)) {
				result = f.toEndpointPaths();
				break;
			}
		}
		return result;
	}

}
