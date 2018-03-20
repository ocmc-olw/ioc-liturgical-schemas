package org.ocmc.ioc.liturgical.schemas.models.db.docs.notes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TextualNoteTest {

	@Test
	public void test() {
		TextualNote note = new TextualNote("en_us_mcolburn", "x", "y");
		note.setValueFormatted("<p>This is a <em>test</em> to see what happens when you <strong>format.</strong></p>");
		System.out.println(note.getValue());
		assertFalse(note.getValue().contains("<"));
	}

}
