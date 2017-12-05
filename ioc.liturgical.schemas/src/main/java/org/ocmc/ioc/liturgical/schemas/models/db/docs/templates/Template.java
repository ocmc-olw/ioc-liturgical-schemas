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
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Template", description = "Template for generation of a book or service")
public class Template extends LTKDb {
    private static final Logger logger = LoggerFactory.getLogger(Template.class);
	private static String schema = Template.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.TEMPLATE_ROOT;

	@Attributes(required = true, description = "The type of template")
	@Expose public TEMPLATE_TYPES type = TEMPLATE_TYPES.SERVICE;

	@Attributes(required = true, description = "A description of the template")
	@Expose public String description = "";
	
	@Attributes(readonly = true, required = true, description = "A string representation of the hierarchical structure of a book or service.  It uses the TemplateNode schema.")
	@Expose public String node = "";
	
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
			TemplateNode tNode = new TemplateNode();
			tNode.setTitle(TEMPLATE_NODE_TYPES.TEMPLATE);
			tNode.setSubtitle(this.id);
			this.node = tNode.toJsonString();
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

	public TemplateNode fetchNode() {
		TemplateNode result = new TemplateNode();
		try {
			if (this.node.length() > 0) {
				result = gson.fromJson(this.node, TemplateNode.class);
			}
		} catch (Exception e) {
		}
		return result;
	}
	
	public void appendNode(TemplateNode node) {
		try {
			TemplateNode tNode = this.fetchNode();
			tNode.appendNode(node);
			this.node = tNode.toJsonString();
		} catch (Exception e) {
		}
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TEMPLATE_TYPES getType() {
		return type;
	}

	public void setType(TEMPLATE_TYPES type) {
		this.type = type;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

}
