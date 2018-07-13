package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.LIBRARIES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.constants.nlp.DEPENDENCY_LABELS_PERSEUS;
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

	@Attributes(id = "top", required = true, description = "The type of template")
	@Expose public TEMPLATE_TYPES type = TEMPLATE_TYPES.SERVICE;
	
	@Attributes(id = "top", minimum = 0, maximum = 12, description = "Month number, starting with 1 for January.  Use zero if not a dated service.")
	@Expose public int month = 0;

	@Attributes(id = "top", minimum = 0, maximum = 31, description = "The day of the month as a number, starting with 1.  Use zero if not a dated service.")
	@Expose public int day = 0;

	@Attributes(id = "top",  minimum = 0, maximum = 3000, description = "The year as a number. Use zero if not a dated service.")
	@Expose public int year = 0;

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

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
