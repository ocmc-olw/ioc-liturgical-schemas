package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;

public class TemplateNodeFactory {
	
	public static TemplateNode getActor(String topic) {
		TemplateNode node = new TemplateNode();
		node.setPrettyPrint(true);
		node.setTitle(TEMPLATE_NODE_TYPES.ACTOR);
		TemplateNode actorSid = new TemplateNode();
		actorSid.setPrettyPrint(true);
		actorSid.setTitle(TEMPLATE_NODE_TYPES.SID);
		actorSid.setSubtitle("Priest");
		node.appendNode(actorSid);
		return node;
	}
	
	public static Template getTemplate(
			String library
			, String topic
			, String key
			, TEMPLATE_TYPES type
			, TEMPLATE_NODE_TYPES nodeType
			) {
		Template template = new Template(library, topic, key);
		TemplateNode node = new TemplateNode();
		node.setTitle(nodeType);
		template.setType(type);
		switch (nodeType) {
		case WHEN_DATE_IS:
			break;
		case WHEN_DAY_NAME_IS:
			TemplateNode sunday = new TemplateNode();
			sunday.setTitle(TEMPLATE_NODE_TYPES.SUNDAY);
			Section sec01 = new Section(template.getLibrary(), template.getId(), "section01");
			sunday.appendNode(sec01.getNode());
			node.appendNode(sunday);
			TemplateNode otherwise = new TemplateNode();
			otherwise.setTitle(TEMPLATE_NODE_TYPES.OTHERWISE);
			Section sec02 = new Section(template.getLibrary(), template.getId(), "section02");
			otherwise.appendNode(sec02.getNode());
			node.appendNode(otherwise);
			break;
		case WHEN_EXISTS:
			break;
		case WHEN_LUKAN_CYCLE_DAY_IS:
			break;
		case WHEN_MODE_OF_WEEK_IS:
			break;
		case WHEN_MOVABLE_CYCLE_DAY_IS:
			break;
		case WHEN_PASCHA:
			break;
		case WHEN_PENTECOSTARIAN_DAY_IS:
			break;
		case WHEN_SUNDAYS_BEFORE_TRIODION:
			break;
		case WHEN_SUNDAY_AFTER_ELEVATION_OF_CROSS_DAY_IS:
			break;
		case WHEN_TRIODION_DAY_IS:
			break;
		default: // SECTION
			node.setTitle(TEMPLATE_NODE_TYPES.SECTION);
			break;
		
		}
		template.appendNode(node);
		return template;
	}

}
