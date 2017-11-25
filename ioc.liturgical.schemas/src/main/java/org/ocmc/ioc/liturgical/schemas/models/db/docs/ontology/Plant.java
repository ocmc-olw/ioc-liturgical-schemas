package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.PlantCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Plant", description = "This is a doc that records information about an earthly being that is not capable of independent motion.")
public class Plant extends LTKDbOntologyEntry {
	
	private static String schema = Plant.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.PLANT;
	
	public Plant(
			String key
			) {
		super(ontoTopic, schema, version, key);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
	
	public Plant(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}


	public Plant(
			PlantCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
	}

}
