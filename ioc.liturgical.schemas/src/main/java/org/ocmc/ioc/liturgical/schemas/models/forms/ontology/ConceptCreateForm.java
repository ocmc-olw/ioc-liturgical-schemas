package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Concept", description = "This is a doc that records information about a concept.")
public class ConceptCreateForm extends LTKOntologyCreateFormEntry {

	public ConceptCreateForm(
			String key
			) {
		super(
				TOPICS.CONCEPT
				, key
				, ConceptCreateForm.class.getSimpleName()
				,  1.1
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
}
