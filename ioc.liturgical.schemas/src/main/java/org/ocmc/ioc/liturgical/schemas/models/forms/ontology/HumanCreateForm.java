package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Human", description = "This is a doc that records information about a human being.")
public class HumanCreateForm extends LTKOntologyCreateFormEntry {

	@Attributes(required = true, description = "Gender")
	@Expose public GENDERS gender = GENDERS.unknown;

	public HumanCreateForm(
			String key
			) {
		super(
				TOPICS.HUMAN
				, key
				, HumanCreateForm.class.getSimpleName()
				,  1.1
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public GENDERS getGender() {
		return gender;
	}

	public void setGender(GENDERS gender) {
		this.gender = gender;
	}
}
