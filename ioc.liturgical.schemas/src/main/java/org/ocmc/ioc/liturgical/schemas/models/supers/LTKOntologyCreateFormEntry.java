package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.SCHEMA_CLASSES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "LTKDbOntology Entry", description = "Abstract ontology Entry")
public class LTKOntologyCreateFormEntry extends LTK {
	
	@Attributes(required = true, description = "Name")
	@Expose public String name = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = false, description = "Description")
	@Expose public String description = "";
	
	public LTKOntologyCreateFormEntry(
			TOPICS topic
			, String key
			, String schema
			, double serialVersion
			) {
		super(
				LIBRARIES.ONTOLOGY.toSystemDomain()
				, topic.label
				, key
				, schema
				,  serialVersion
				, topic
				);
		this.name = key;
	}

	public LTKOntologyCreateFormEntry(
			LTKOntologyCreateFormEntry form
			) {
		super(
				LIBRARIES.ONTOLOGY.toSystemDomain()
				, form.getTopic()
				, form.getKey()
				, SCHEMA_CLASSES.classForSchemaName(form._valueSchemaId).ltkDb.schemaIdAsString()
				, SCHEMA_CLASSES.classForSchemaName(form._valueSchemaId).ltkDb.schemaIdAsNumber()
				, form.getOntologyTopic()
				);
		this.description = form.getDescription();
		this.name = form.getName();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
