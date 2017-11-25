package org.ocmc.ioc.liturgical.schemas.models.db.links;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.RELATIONSHIP_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.LinkRefersToPlaceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLink;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Reference to Place", description = "This is a doc that records information about a reference made in a text to some place.  For example, a liturgical text might be a hymn that refers to the Jordan River.")
public class LinkRefersToPlace extends LTKLink {

	private static double serialVersion = 1.1;
	private static String schema = LinkRefersToPlace.class.getSimpleName();
	private static RELATIONSHIP_TYPES type = RELATIONSHIP_TYPES.REFERS_TO_PLACE;
	private static TOPICS ontoTopic = TOPICS.PLACE;

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Word or phrase that makes the reference")
	@Expose public String referredByPhrase = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Comments about the reference")
	@Expose public String comments = "";

	public LinkRefersToPlace(
			String library
			, String topic
			, String key
			) {
		super(library
				, topic
				, key
				, LinkRefersToPlace.schema
				, LinkRefersToPlace.serialVersion
				, LinkRefersToPlace.type
				, LinkRefersToPlace.ontoTopic
			);
	}

	public LinkRefersToPlace(LinkRefersToPlaceCreateForm form) {
		super(form.getLibrary()
		, form.getTopic()
		, form.getKey()
		, LinkRefersToPlace.schema
		, LinkRefersToPlace.serialVersion
		, LinkRefersToPlace.type
		, LinkRefersToPlace.ontoTopic
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
