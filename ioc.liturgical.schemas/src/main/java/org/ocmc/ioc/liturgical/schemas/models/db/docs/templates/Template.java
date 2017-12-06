package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.DEPENDENCY_LABELS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.PARTS_OF_SPEECH;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.ontology.Animal;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGenerationUnit;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Template", description = "Template for generation of a book or service")
public class Template extends LTKDbGenerationUnit {
    private static final Logger logger = LoggerFactory.getLogger(Template.class);
	private static String schema = Template.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.TEMPLATE;

	@Attributes(required = true, description = "The type of template")
	@Expose public TEMPLATE_TYPES type = TEMPLATE_TYPES.SERVICE;

	public Template(
			String library
			, String topic
			) {
		super(
				library
				, topic
				, Constants.TEMPLATE_KEY
				, schema
				,  version
				, enumTopic
				);
		try {
			TemplateNode tNode = TemplateNodeFactory.getTemplateRootNode(
					library
					, topic
					, TEMPLATE_TYPES.SERVICE
					, TEMPLATE_NODE_TYPES.SECTION
					);
			tNode.setTitle(TEMPLATE_NODE_TYPES.TEMPLATE);
			tNode.setSubtitle(this.id);
			this.node = tNode.toJsonString();
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

	public TEMPLATE_TYPES getType() {
		return type;
	}

	public void setType(TEMPLATE_TYPES type) {
		this.type = type;
	}

}
