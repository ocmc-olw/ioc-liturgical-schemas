package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Place", description = "This is a doc that records information about a place.")
public class PlaceCreateForm extends LTKOntologyCreateFormEntry {

	public PlaceCreateForm(
			String key
			) {
		super(
				TOPICS.PLACE
				, key
				, PlaceCreateForm.class.getSimpleName()
				,  1.1
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
}
