package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;

public class TemplateTest {

	@Test
	public void test1() {
		// create a Template
		Template template = new Template("en_us_ages", "datedServices", "se.m01.d01.ma");
		template.setPrettyPrint(true);
		// create an actor node
		TemplateNode actorNode = TemplateNodeFactory.getActor("Priest");

		// create a section
		Section section01 = new Section("en_us_ages",template.getId(),"section01");
		section01.setPrettyPrint(true);
		section01.appendNode(actorNode);
		
		// add the section to the template
		template.appendNode(section01.node);
		
		String json = template.getNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}

	@Test
	public void test2() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "datedServices"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_DAY_NAME_IS
				);
		template.setPrettyPrint(true);
		String json = template.getNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
}
