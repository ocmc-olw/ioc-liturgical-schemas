package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Section", description = "Section of a Template for generation of a book or service")
public class Section extends LTKDb {
	private static String schema = Section.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.SECTION;

	@Attributes(required = true, description = "A description of the section")
	@Expose String description = "";
	
	@Attributes(required = true, description = "A description of the template")
	@Expose TemplateNode node = new TemplateNode();
	
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
		this.node.setTitle(TEMPLATE_NODE_TYPES.SECTION);
		this.node.setSubtitle(this.getTopic() + Constants.ID_DELIMITER + this.getKey());
	}

	public void appendNode(TemplateNode node) {
		this.node.appendNode(node);
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TemplateNode getNode() {
		return node;
	}

	public void setNode(TemplateNode node) {
		this.node = node;
	}

}
