package org.ocmc.ioc.liturgical.schemas.models.forms.template;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class TemplateConfigTest {

	@Test
	public void test() {
		TemplateConfig config = new TemplateConfig();
		config.setDay(20);
		config.setMonth(12);
		JsonObject uiSchemaObject = config.toJsonUiSchemaObject();
		JsonArray array = uiSchemaObject.get("ui:order").getAsJsonArray();
		assertTrue(array.size() == 5);
//		config.setPrettyPrint(true);
//		JsonObject schemaObject = config.toJsonSchemaObject();
//		String jsonString = config.toJsonString();
//		System.out.println(jsonString);
//		System.out.println(schemaObject.toString());
//		System.out.println(uiSchemaObject.toString());
	}

}
