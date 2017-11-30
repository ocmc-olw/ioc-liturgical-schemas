package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Group", description = "This is a doc that records information about a group of people, e.g. a kingdom, or a monastery.")
public class GroupCreateForm extends LTKOntologyCreateFormEntry {

	public GroupCreateForm(
			String key
			) {
		super(
				TOPICS.GROUP
				, key
				, GroupCreateForm.class.getSimpleName()
				,  1.1
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
}
