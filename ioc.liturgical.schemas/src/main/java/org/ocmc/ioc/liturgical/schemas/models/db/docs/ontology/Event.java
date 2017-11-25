package org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.CENTURIES;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.EventCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbOntologyEntry;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Event", description = "This is a doc that records information about an event, e.g. the birth of Christ.")
public class Event extends LTKDbOntologyEntry {
	
	private static String schema = Event.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.EVENT;
	
	@Attributes(required = true, description = "Century in which the event started")
	@Expose public CENTURIES startCentury = CENTURIES.UNKNOWN;

	@Attributes(required = true, description = "Century in which the event ended")
	@Expose public CENTURIES endCentury = CENTURIES.UNKNOWN;

	public Event(
			String key
			) {
		super(ontoTopic, schema, version, key);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public Event(
			String key
			, String name
			) {
		super(ontoTopic, schema, version, key);
		this.name = name;
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
	}

	public Event(
			EventCreateForm form
			) {
		super(ontoTopic, schema,  version, form);
	}

	public CENTURIES getStartCentury() {
		return startCentury;
	}

	public void setStartCentury(CENTURIES startCentury) {
		this.startCentury = startCentury;
	}

	public CENTURIES getEndCentury() {
		return endCentury;
	}

	public void setEndCentury(CENTURIES endCentury) {
		this.endCentury = endCentury;
	}

}
