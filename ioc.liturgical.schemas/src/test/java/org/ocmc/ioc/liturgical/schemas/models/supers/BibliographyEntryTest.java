package org.ocmc.ioc.liturgical.schemas.models.supers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.ocmc.ioc.liturgical.schemas.models.bibliography.BibEntryArticle;

public class BibliographyEntryTest {

	@Test
	public void testArticle() {
		BibEntryArticle article = new BibEntryArticle("en_us_somebody", "vonFritz:2015");
		article.setAuthor("von Fritz, Kurt");
		article.setJournaltitle("WORD");
		article.setNumber("2");
		article.setPages("186-201");
		article.setTitle("The So-Called Historical Present in Early Greek");
		article.setVolume("5");
		article.setDate("2015");
		String bibTex = article.toBibtex();
		System.out.println(bibTex);
		assertTrue(bibTex.length() > 0);
	}

}
