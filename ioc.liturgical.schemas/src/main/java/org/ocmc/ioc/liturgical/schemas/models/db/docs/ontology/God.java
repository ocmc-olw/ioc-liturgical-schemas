package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.BeingCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.GodCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "God", description = "This is a doc that records information about God or a person of the Holy Trinity.")
public class God extends LTKDbOntologyEntry {
	
	private static String schema = God.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.GOD;
	
	public God(
			String key
			) {
		super(ontoTopic, schema, version, key);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public God(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public God(
			GodCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
	}
}
