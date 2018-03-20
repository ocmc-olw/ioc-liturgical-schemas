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
	
	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The type of this note.")
	@Expose public NOTE_TYPES noteType = NOTE_TYPES.GENERAL;

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the liturgical Greek text referenced by this note.")
	@Expose public String liturgicalGreekId = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the liturgical Greek text referenced by this note.")
	@Expose public String liturgicalTranslationId = "";

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The textual scope of this note.")
	@Expose public String liturgicalScope = ""; 

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The title of this note.")
	@Expose public String noteTitle = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The lemma about which this note is made.")
	@Expose public String liturgicalLemma = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the Biblical Greek text referred to.")
	@Expose public String biblicalGreekId = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the Biblical translation text referred to.")
	@Expose public String biblicalTranslationId = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The Biblical scope of the note.")
	@Expose public String biblicalScope = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The Biblical lemma(s) referred to in the note.")
	@Expose public String biblicalLemma = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the ontological entity the liturgical Greek text refers to.")
	@Expose public String ontologicalEntityId = "";

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


	public String getLiturgicalGreekId() {
		return liturgicalGreekId;
	}


	public void setLiturgicalGreekId(String liturgicalGreekId) {
		this.liturgicalGreekId = liturgicalGreekId;
	}


	public String getLiturgicalTranslationId() {
		return liturgicalTranslationId;
	}


	public void setLiturgicalTranslationId(String liturgicalTranslationId) {
		this.liturgicalTranslationId = liturgicalTranslationId;
	}


	public String getLiturgicalScope() {
		return liturgicalScope;
	}


	public void setLiturgicalScope(String liturgicalScope) {
		this.liturgicalScope = liturgicalScope;
	}


	public NOTE_TYPES getNoteType() {
		return noteType;
	}


	public void setNoteType(NOTE_TYPES noteType) {
		this.noteType = noteType;
	}


	public String getNoteTitle() {
		return noteTitle;
	}


	public void setNoteTitle(String noteTitle) {
		this.noteTitle = noteTitle;
	}


	public String getLiturgicalLemma() {
		return liturgicalLemma;
	}


	public void setLiturgicalLemma(String liturgicalLemma) {
		this.liturgicalLemma = liturgicalLemma;
	}


	public String getBiblicalGreekId() {
		return biblicalGreekId;
	}


	public void setBiblicalGreekId(String biblicalGreekId) {
		this.biblicalGreekId = biblicalGreekId;
	}


	public String getBiblicalTranslationId() {
		return biblicalTranslationId;
	}


	public void setBiblicalTranslationId(String biblicalTranslationId) {
		this.biblicalTranslationId = biblicalTranslationId;
	}


	public String getBiblicalScope() {
		return biblicalScope;
	}


	public void setBiblicalScope(String biblicalScope) {
		this.biblicalScope = biblicalScope;
	}


	public String getBiblicalLemma() {
		return biblicalLemma;
	}


	public void setBiblicalLemma(String biblicalLemma) {
		this.biblicalLemma = biblicalLemma;
	}


	public String getOntologicalEntityId() {
		return ontologicalEntityId;
	}


	public void setOntologicalEntityId(String ontologicalEntityId) {
		this.ontologicalEntityId = ontologicalEntityId;
	}

}
