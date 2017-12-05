package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * POJO used to create Json to be used client-side by the react-sortable-tree package.
 * Because of this, the property names 	"title", "subtitle", and "children" are used.
 * For our purposes, the title is actually the Template Node Type, and the subtitle
 * is either a user entered identifier, or the ID of a Template or a Section or a doc.
 * The meaning of the subtitle depends on the Template Node Type.
 * @author mac002
 *
 */
@Attributes(title = "Template Node", description = "A part of a template.  Templates are used to generation of a book or service")
public class TemplateNode  extends AbstractModel {
	@Expose public TEMPLATE_NODE_TYPES title = null;
	@Expose public String subtitle = "";
	@Expose public List<TemplateNode> children = new ArrayList<TemplateNode>();
	
	public TemplateNode() {
		super();
	}
	
	public void appendNode(TemplateNode child) {
		this.children.add(child);
	}
	public TEMPLATE_NODE_TYPES getTitle() {
		return title;
	}
	public void setTitle(TEMPLATE_NODE_TYPES title) {
		this.title = title;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public List<TemplateNode> getChildren() {
		return children;
	}
	public void setChildren(List<TemplateNode> children) {
		this.children = children;
	}
	
	/**
	 * 
	 * @param type to filter for
	 * @return children nodes that match the specified type
	 */
	public List<TemplateNode> filter(TEMPLATE_NODE_TYPES type) {
		return filter(this, type);
	}

	private List<TemplateNode> filter(
			TemplateNode node
			, TEMPLATE_NODE_TYPES type
			) {
		List<TemplateNode> result = new ArrayList<TemplateNode>();
		if (node.title == type) {
			result.add(node);
		} else {
			for (TemplateNode child : node.children) {
				result.addAll(filter(child, type));
			}
		}
		return result;
	}

}
