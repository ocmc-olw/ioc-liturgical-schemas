package org.ocmc.ioc.liturgical.schemas.id.managers;

import static org.junit.Assert.*;

import org.junit.Test;

public class IdManagerTest {

	@Test
	public void test() {
		String dataKey = "sy.m06.d10_spa_GT_odg|cl.S01.commemoration.text";
		IdManager idManager = new IdManager(IdManager.dataKeyToId(dataKey));
		String formattedDate  = idManager.getLocaleDate("2018", "4","2");
		assertTrue(formattedDate.equals("lunes 2 de abril de 2018"));
	}

}
