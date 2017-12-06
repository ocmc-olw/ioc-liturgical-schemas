package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbGenerationUnit;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Section", description = "Section for generation of a book or service")
public class Section extends LTKDbGenerationUnit {
    private static final Logger logger = LoggerFactory.getLogger(Section.class);
	private static String schema = Section.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS enumTopic = TOPICS.SECTION;

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
			tNode.setSubtitle(this.id);
			this.node = tNode.toJsonString();
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
	}

}
