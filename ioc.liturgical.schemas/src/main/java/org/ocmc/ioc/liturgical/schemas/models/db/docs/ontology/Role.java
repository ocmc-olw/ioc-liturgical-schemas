package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.AnimalCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Role", description = "This is a form to record information about a role, e.g. King, Father, Mother, Saint.  Definition of Role: 'the function or position that somebody has or is expected to have in an organization, in society or in a relationship.' (Oxford Learner's Dictionary)")
public class Role extends LTKDbOntologyEntry {
	
	private static String schema = Role.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.ROLE;
	
	public Role(
			String key
			) {
		super(ontoTopic, schema, version, key);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public Role(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public Role(
			AnimalCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
	}

}
