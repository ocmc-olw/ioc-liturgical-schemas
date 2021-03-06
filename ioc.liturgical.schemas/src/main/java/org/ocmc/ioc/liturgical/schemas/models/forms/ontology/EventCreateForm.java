package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import org.ocmc.ioc.liturgical.schemas.constants.CENTURIES;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKOntologyCreateFormEntry;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * @author mac002
 *
 */
@Attributes(title = "Event", description = "This is a doc that records information about an event, e.g. the birth of Christ.")
public class EventCreateForm extends LTKOntologyCreateFormEntry {

	private static double serialVersion = 1.1;
	private static String schema = EventCreateForm.class.getSimpleName();

	@Attributes(required = true, description = "Century in which the event started")
	@Expose public CENTURIES startCentury = CENTURIES.UNKNOWN;

	@Attributes(required = true, description = "Century in which the event ended")
	@Expose public CENTURIES endCentury = CENTURIES.UNKNOWN;


	public EventCreateForm(
			String key
			) {
		super(
				TOPICS.EVENT
				, key
				, schema
				,  serialVersion
				);
		this.partTypeOfTopic = ID_PART_TYPES.ONTOLOGY_TOPIC;
		this.partTypeOfKey = ID_PART_TYPES.USER_TEXT;
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
	
	public static void main(String [] args) {
		EventCreateForm f = new EventCreateForm("");
		f.setPrettyPrint(true);
	}


}
