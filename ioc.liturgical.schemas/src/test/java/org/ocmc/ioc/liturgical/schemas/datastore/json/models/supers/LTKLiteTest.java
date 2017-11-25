package org.ocmc.ioc.liturgical.schemas.datastore.json.models.supers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKLite;

import com.google.gson.JsonObject;

public class LTKLiteTest {

	@Test
	public void test() {
		String library = "gr_gr_cog";
		String topic = "actors";
		String key = "Priest";
		LTKLite text = new LTKLite(
				library
				, topic
				, key
				, "Liturgical"
				, 1.1
		);
		JsonObject json = text.toJsonObject();
		assertTrue(json.get("library").getAsString().equals(library));
	}

}
