package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;

public class TemplateNodeFactory {
	
	public static Template getTemplate(
			String library
			, String topic
			, TEMPLATE_TYPES type
			, TEMPLATE_NODE_TYPES nodeType
			) {
		Template template = new Template(library, topic);
		TemplateNode node = new TemplateNode();
		node.setTitle(nodeType);
		template.setType(type);
		switch (nodeType) {
		case WHEN_DATE_IS:
			break;
		case WHEN_DAY_NAME_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getDaysOfWeek()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		case WHEN_DAY_OF_MONTH_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getDaysOfMonth()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		case WHEN_EXISTS:
			break;
		case WHEN_LUKAN_CYCLE_DAY_IS:
			break;
		case WHEN_MONTH_NAME_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getMonths()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		case WHEN_MODE_OF_WEEK_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getModes()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		case WHEN_MOVABLE_CYCLE_DAY_IS:
			break;
		case WHEN_PASCHA:
			break;
		case WHEN_PENTECOSTARIAN_DAY_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getDaysOfSeason()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		case WHEN_SUNDAYS_BEFORE_TRIODION:
			break;
		case WHEN_SUNDAY_AFTER_ELEVATION_OF_CROSS_DAY_IS:
			break;
		case WHEN_TRIODION_DAY_IS:
			for (TEMPLATE_NODE_TYPES theType : TEMPLATE_NODE_TYPES.getDaysOfSeason()) {
				node.appendNode(
						getSectionNode(
								nodeType
								, theType
								, template.getLibrary()
								, template.getTopic()
								)
						);
			}
			break;
		default: // SECTION
			node.setTitle(TEMPLATE_NODE_TYPES.SECTION);
			break;
		
		}
		template.appendNode(node);
		return template;
	}
	
	private static String sectionSuffix(TEMPLATE_NODE_TYPES test, TEMPLATE_NODE_TYPES type) {
		return "_" + test.name().toLowerCase() + "_" + type.name().toLowerCase();
	}
	
	private static TemplateNode getSectionNode(
			TEMPLATE_NODE_TYPES nodeType
			, TEMPLATE_NODE_TYPES theType
			, String library
			, String topic
			) {
		TemplateNode childNode = new TemplateNode();
		childNode.setTitle(theType);
		Section section = new Section(
				library
				, topic
				, "section" + sectionSuffix(nodeType, theType));
		childNode.appendNode(section.fetchNode());
		return childNode;
	}

}
