package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.SECTION_PARTS;
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

	@Attributes(readonly = true, required = true, description = "A description of the section")
	@Expose SECTION_PARTS title = SECTION_PARTS.SECTION;

	@Attributes(readonly = true, required = true, description = "A description of the section")
	@Expose String subtitle = "";

	@Attributes(required = true, description = "A description of the section")
	@Expose String description = "";
	
	@Attributes(required = true, description = "A description of the section")
	@Expose List<SectionPart> children = new ArrayList<SectionPart>();
	
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
		this.subtitle = this.getId();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public List<SectionPart> getChildren() {
		return children;
	}

	public void setChildren(List<SectionPart> children) {
		this.children = children;
	}

	public SECTION_PARTS getTitle() {
		return title;
	}

	public void setTitle(SECTION_PARTS title) {
		this.title = title;
	}

}
