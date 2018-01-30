package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.WsPaths;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.ConcordanceLine;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.nlp.WordAnalysis;
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
	NEW_ANIMAL(
			"Animal"
			, new AnimalCreateForm("")
			, ENDPOINTS_DB_API.DOCS
			, RESTRICTION_FILTERS.NONE
			)
,	NEW_LINK_REFERS_TO_ANIMAL(
			"doc refers animal"
			, new LinkRefersToAnimalCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			)
,	NEW_BEING(
		"Being"
		, new BeingCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
,	NEW_LINK_REFERS_TO_BEING(
			"doc refers to being"
			, new LinkRefersToBeingCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			)
,	NEW_LINK_REFERS_TO_BIBLICAL_TEXT(
			"doc refers to biblical text"
			, new LinkRefersToBiblicalTextCreateForm("","","")
			, ENDPOINTS_DB_API.LINKS
			, RESTRICTION_FILTERS.NONE
			)
, NEW_CONCEPT(
		"Concept"
		, new ConceptCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_CONCORDANCE_LINE(
		"ConcordanceLine"
		, new ConcordanceLine(" ",0,0," "," "," ")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_CONCEPT(
		"doc refers to concept"
		, new LinkRefersToConceptCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_EVENT(
		"Event"
		, new EventCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_EVENT(
		"doc refers to event"
		, new LinkRefersToEventCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_GOD(
		"doc refers to God"
		, new LinkRefersToGodCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_GROUP(
		"Group"
		, new GroupCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_GROUP(
		"doc refers to group"
		, new LinkRefersToGroupCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_HUMAN(
		"Human"
		, new HumanCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_HUMAN(
		"doc refers to human"
		, new LinkRefersToHumanCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_MYSTERY(
		"Mystery"
		, new MysteryCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_MYSTERY(
		"doc refers to mystery"
		, new LinkRefersToMysteryCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_NOTE_USER(
		"Note (private)"
		, new UserNoteCreateForm(" ", " ", " ")
		, ENDPOINTS_DB_API.NOTES
		, RESTRICTION_FILTERS.NONE
		)
, NEW_OBJECT(
		"Object"
		, new ObjectCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_OBJECT(
		"doc refers to object"
		, new LinkRefersToObjectCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_WORD_ANALYSIS(
		"Word Analysis"
		, new WordAnalysis()
		, ENDPOINTS_DB_API.WORD_ANALYSIS
		, RESTRICTION_FILTERS.WS_ADMIN
		)
, NEW_PLACE(
		"Place"
		, new PlaceCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TEMPLATE(
		"Template"
		, new Template("","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
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
		)
, NEW_LINK_REFERS_TO_PLACE(
		"doc refers to place"
		, new LinkRefersToPlaceCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_PLANT(
		"Plant"
		, new PlantCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_PLANT(
		"doc refers to plant"
		, new LinkRefersToPlantCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_ROLE(
		"Role"
		, new RoleCreateForm("")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_LINK_REFERS_TO_ROLE(
		"doc refers to role"
		, new LinkRefersToRoleCreateForm("","","")
		, ENDPOINTS_DB_API.LINKS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TEXT_BIBLICAL_SOURCE(
		"Biblical Text (Source)"
		, new TextBiblicalSourceCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TEXT_BIBLICAL_TRANSLATION(
		"Biblical Text (Translation)"
		, new TextBiblicalTranslationCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TEXT_LITURGICAL_TRANSLATION(
		"Liturgical Text (Translation)"
		, new TextLiturgicalTranslationCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TEXT_LITURGICAL_SOURCE(
		"Liturgical Text (Source)"
		, new TextLiturgicalSourceCreateForm("","","")
		, ENDPOINTS_DB_API.DOCS
		, RESTRICTION_FILTERS.NONE
		)
, NEW_TOKEN_ANALYSIS(
		"Token Analysis"
		, new TokenAnalysisCreateForm("","")
		, ENDPOINTS_DB_API.TOKEN_ANALYSIS
		, RESTRICTION_FILTERS.NONE
		)
	;

	public AbstractModel obj;
	public ENDPOINTS_DB_API endpoint;
	public String name;
	public RESTRICTION_FILTERS restriction;
	
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
			) {
		this.name = name;
		this.obj = obj;
		this.endpoint = endpoint;
		this.restriction = restriction;
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
