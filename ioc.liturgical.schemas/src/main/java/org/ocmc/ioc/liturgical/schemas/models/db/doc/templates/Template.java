package org.ocmc.ioc.liturgical.schemas.models.db.doc.templates;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.DEPENDENCY_LABELS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.PARTS_OF_SPEECH;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Animal;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Template", description = "Template for generation of a book or service")
public class Template extends LTKDb {
	private static String schema = Template.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.TEMPLATE_ROOT;

	@Attributes(required = true, description = "A description of the template")
	@Expose String description = "";
	
	public Template(
			String library
			, String topic
			, String key
			) {
		super(
				library
				, topic
				, key
				, schema
				,  version
				, enumTopic
				);
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
