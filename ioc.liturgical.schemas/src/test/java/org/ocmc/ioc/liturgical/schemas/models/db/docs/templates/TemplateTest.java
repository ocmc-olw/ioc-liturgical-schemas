package org.ocmc.ioc.liturgical.schemas.models.db.docs.templates;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_NODE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TEMPLATE_TYPES;

import com.google.gson.JsonObject;

public class TemplateTest {

	@Test
	public void testDayOfWeekName() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_DAY_NAME_IS
				);
		template.setPrettyPrint(true);
		JsonObject o = template.fetchNode().toJsonObject();
		String json = o.toString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testSectionExtraction() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_DAY_NAME_IS
				);
		List<TemplateNode> sections = template.fetchNode().filter(
				TEMPLATE_NODE_TYPES.SECTION
				);
		for (TemplateNode section : sections) {
			System.out.println(section.title.name() + ": " + section.subtitle);
		}
		template.setPrettyPrint(true);
		String json = template.toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testMonthName() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_MONTH_NAME_IS
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testMonthDay() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_DAY_OF_MONTH_IS
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testTriodionDay() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_TRIODION_DAY_IS
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testPentecostarianDay() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_PENTECOSTARIAN_DAY_IS
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testMode() {
		// create a Template
		Template template = TemplateNodeFactory.getTemplate(
				"en_us_ages"
				, "se.m01.d01.ma"
				, TEMPLATE_TYPES.SERVICE
				, TEMPLATE_NODE_TYPES.WHEN_MODE_OF_WEEK_IS
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	@Test
	public void testTemplateInstantiation() {
		// create a Template
		Template template = new Template(
				"en_us_ages"
				, "se.m01.d01.ma"
				);
		template.setPrettyPrint(true);
		String json = template.fetchNode().toJsonString();
		System.out.println(json);
		assertTrue(json.length() > 0);
	}
	
}
