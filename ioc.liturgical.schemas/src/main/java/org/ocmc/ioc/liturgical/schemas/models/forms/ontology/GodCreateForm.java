package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * This provides a form to create a doc that contains information about God
 * @author mac002
 *
 */
@Attributes(title = "God", description = "This is a doc that records information about God or one of the Holy Trinity.")
public class GodCreateForm extends LTKOntologyCreateFormEntry {

	public GodCreateForm(
			String key
			) {
		super(
				TOPICS.GOD
				, key
				, GodCreateForm.class.getSimpleName()
				,  1.1
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
}
