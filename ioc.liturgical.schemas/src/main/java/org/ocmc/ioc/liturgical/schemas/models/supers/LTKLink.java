package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.RELATIONSHIP_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "LTK Link", description = "Abstract Link with Properties")
public class LTKLink extends LTKDb {

	@Attributes(id="bottom",required = true, readonly = true, minLength = 1, description = "The type of link.")
	@Expose public RELATIONSHIP_TYPES type = null;
	
	public LTKLink(
			String library
			, String topic
			, String key
			, String schema
			, double serialVersion
			, RELATIONSHIP_TYPES type
			, TOPICS ontoTopic
			) {
		super(
				library
				, topic
				, key
				, schema
				,  serialVersion
				, ontoTopic
				);
		this.type = type;
	}

	public LTKLink(
			TOPICS topic
			, String schema
			, double serialVersion
			, LTKOntologyCreateFormEntry form
			) {
		super(
				LIBRARIES.ONTOLOGY.toSystemDomain()
				, topic.label
				, form.getKey()
				, schema
				,  serialVersion
				, topic
				);
	}

	public RELATIONSHIP_TYPES getType() {
		return type;
	}

	public void setType(RELATIONSHIP_TYPES type) {
		this.type = type;
	}

}
