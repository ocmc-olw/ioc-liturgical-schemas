package org.ocmc.ioc.liturgical.schemas.models.db.links;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.RELATIONSHIP_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToBeingCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink;

import com.github.reinert.jjschema.Attributes;

/**
 * This class provides a POJO for use in web forms to create or update a domain
 * @author mac002
 *
 */
@Attributes(title = "Reference to Being", description = "This is a doc that records information about a reference made in a text to a being.  For example, a liturgical text might be a hymn that refers to an angel.  Note that there are some subtypes of being: animal, human, plant.  Use the subytype if applicable.")
public class LinkRefersToBeing extends LTKLink {

	private static double serialVersion = 1.1;
	private static String schema = LinkRefersToBeing.class.getSimpleName();
	private static RELATIONSHIP_TYPES type = RELATIONSHIP_TYPES.REFERS_TO_BEING;
	private static TOPICS ontoTopic = TOPICS.BEING;

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Word or phrase that makes the reference")
	@Expose public String referredByPhrase = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Comments about the reference")
	@Expose public String comments = "";

	public LinkRefersToBeing(
			String library
			, String topic
			, String key
			) {
		super(
				library
				, topic
				, key
				, LinkRefersToBeing.schema
				, LinkRefersToBeing.serialVersion
				, LinkRefersToBeing.type
				, LinkRefersToBeing.ontoTopic
				);
	}

	public LinkRefersToBeing(LinkRefersToBeingCreateForm form) {
		super(form.getLibrary()
				, form.getTopic()
				, form.getKey()
				, LinkRefersToBeing.schema
				, LinkRefersToBeing.serialVersion
				, LinkRefersToBeing.type
				, LinkRefersToBeing.ontoTopic
				);
		this.setReferredByPhrase(form.getReferredByPhrase());
		this.setComments(form.getComments());
	}
    
	public String getReferredByPhrase() {
		return referredByPhrase;
	}

	public void setReferredByPhrase(String referredByPhrase) {
		this.referredByPhrase = referredByPhrase;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
