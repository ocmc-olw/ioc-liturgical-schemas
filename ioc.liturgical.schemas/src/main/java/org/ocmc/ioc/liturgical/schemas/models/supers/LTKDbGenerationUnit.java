package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.db.docs.templates.TemplateNode;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Generation Unit", description = "Super class for things used for generation of a book or service")
public class LTKDbGenerationUnit extends LTKDb {
    private static final Logger logger = LoggerFactory.getLogger(LTKDbGenerationUnit.class);

	@Attributes(id = "top", required = true, description = "A description of the generation unit")
	@Expose public String description = "";
	
	@Attributes(id = "bottom", readonly = true, required = true, description = "A string representation of the hierarchical structure of a book or service.  It uses the TemplateNode schema.")
	@Expose public String node = "";
	
	public LTKDbGenerationUnit(
			String library
			, String topic
			, String key
			, String schema
			,  double version
			, TOPICS enumTopic
			) {
		super(
				library
				, topic
				, key
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

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

}
