package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;


import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.NOTE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.constants.VISIBILITY;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKNoteCreateForm;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * This class provides a POJO for use in web forms to create or update a textual note
 * @author mac002
 *
 */
@Attributes(title = "Textual Note", description = "This form allows you to enter or read textual notes.")
public class TextNoteCreateForm extends LTKNoteCreateForm {
	
	private static double serialVersion = 1.1;
	private static String schema = TextNoteCreateForm.class.getSimpleName();
	private static TOPICS ontoTopic = TOPICS.NOTE_TEXTUAL;
	
	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The textual scope of this note.")
	@Expose public String scope = "";

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The type of this note.")
	@Expose public NOTE_TYPES noteType = NOTE_TYPES.GENERAL;

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The title of this note.")
	@Expose public String title = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The lemma about which this note is made.")
	@Expose public String lemma = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The Biblical reference made by the text.")
	@Expose public String bibref = "";

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public NOTE_TYPES getNoteType() {
		return noteType;
	}

	public void setNoteType(NOTE_TYPES noteType) {
		this.noteType = noteType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getBibref() {
		return bibref;
	}

	public void setBibref(String bibref) {
		this.bibref = bibref;
	}

	public TextNoteCreateForm(
			String libraryForTheNote
			, String textId
			, String key
			) {
		super(
				libraryForTheNote
				, textId
				, key
				, TextNoteCreateForm.schema
				,  TextNoteCreateForm.serialVersion
				, TextNoteCreateForm.ontoTopic
				);
		this.partTypeOfTopic = ID_PART_TYPES.NOTE_USING_ID_OF_SELECTED_TEXT;
		this.partTypeOfKey = ID_PART_TYPES.TIMESTAMP;
		this.setSeq(this.getId());
		this.setVisibility(VISIBILITY.PERSONAL);
	}

}
