package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.GENDERS;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.HumanCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Human", description = "This is a doc that records information about a human being.")
public class Human extends LTKDbOntologyEntry {
	
	private static String schema = Human.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.HUMAN;
	
	@Attributes(required = true, description = "Gender")
	@Expose public GENDERS gender = GENDERS.unknown;

	public Human(
			String key
			) {
		super(ontoTopic, schema, version, key);
	}
	
	public Human(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}


	public Human(
			HumanCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
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
