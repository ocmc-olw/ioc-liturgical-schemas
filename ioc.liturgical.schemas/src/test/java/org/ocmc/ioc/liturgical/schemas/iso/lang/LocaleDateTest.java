package org.ocmc.ioc.liturgical.schemas.iso.lang;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.id.managers.IdManager;

public class LocaleDateTest {

	@Test
	public void test() {
		String dataKey = "sy.m06.d10_spa_GT_odg|cl.S01.commemoration.text";
		IdManager idManager = new IdManager(IdManager.dataKeyToId(dataKey));
		Locale locale = idManager.getLocale();
		LocaleDate localeDate = new LocaleDate(locale, "2018", "4","2");
		assertTrue(localeDate.getDateFull().equals("lunes 2 de abril de 2018"));
	}

}
