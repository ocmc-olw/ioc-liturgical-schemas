package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Section", description = "Section of a Template for generation of a book or service")
public class Section extends LTKDb {
    private static final Logger logger = LoggerFactory.getLogger(Section.class);
	private static String schema = Section.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.SECTION;

	@Attributes(required = true, description = "A description of the section")
	@Expose public String description = "";
	
	@Attributes(readonly = true, required = true, description = "A string representation of the hierarchical structure of a book or service.  It uses the TemplateNode schema.")
	@Expose public String node = "";
	
	/**
	 * 
	 * @param library the library part of the template ID
	 * @param topic the topic part of the template ID
	 * @param key a user created key
	 */
	public Section(
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
		try {
			TemplateNode tNode = new TemplateNode();
			tNode.setTitle(TEMPLATE_NODE_TYPES.SECTION);
			tNode.setSubtitle(this.getId());
			this.node = tNode.toJsonString();
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

	public void appendNode(TemplateNode node) {
		try {
			TemplateNode tNode = this.fetchNode();
			tNode.appendNode(node);
			this.node = tNode.toJsonString();
		} catch (Exception e) {
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
