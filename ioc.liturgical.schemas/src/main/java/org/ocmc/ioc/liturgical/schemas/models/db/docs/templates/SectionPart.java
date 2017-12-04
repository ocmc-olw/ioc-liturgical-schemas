package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.SECTION_PARTS;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Section Part", description = "A part of a section.  Sections are used in a Template for generation of a book or service")
public class SectionPart  extends AbstractModel {
	@Expose SECTION_PARTS title = null;
	@Expose String subtitle = "";
	@Expose List<SectionPart> children = new ArrayList<SectionPart>();
	public SECTION_PARTS getTitle() {
		return title;
	}
	public void setTitle(SECTION_PARTS title) {
		this.title = title;
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
}
