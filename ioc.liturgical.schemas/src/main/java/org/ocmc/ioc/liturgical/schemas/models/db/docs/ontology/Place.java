package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.PlaceCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Place", description = "This is a doc that records information about a place.")
public class Place extends LTKDbOntologyEntry {
	
	private static String schema = Place.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.PLACE;
	
	public Place(
			String key
			) {
		super(ontoTopic, schema, version, key);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}
	
	public Place(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}


	public Place(
			PlaceCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
	}

}
