package org.ocmc.ioc.liturgical.schemas.models.db.docs.notes;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.NOTE_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.UserNoteCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbNote;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

@Attributes(title = "Text Note ", description = "This form allows you to enter or read notes about the text shown above.")
public class TextualNote extends LTKDbNote {
	
	private static String schema = TextualNote.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.NOTE_TEXTUAL;
	
	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The textual scope of this note.")
	@Expose public String scope = "";

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The type of this note.")
	@Expose public NOTE_TYPES noteType = NOTE_TYPES.GENERAL;

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

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The title of this note.")
	@Expose public String title = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The lemma about which this note is made.")
	@Expose public String lemma = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The Biblical reference made by the text.")
	@Expose public String bibref = "";


	/**
	 * 
	 * @param library - the library containing the text
	 * @param topic - the ID of the Biblical or Liturgical text
	 * @param key - date-time stamp
	 */
	public TextualNote(
			String library
			, String topic
			, String key
			) {
		super(
				library
				, topic
				, key
				, schema
				, version
				, ontoTopic
				);
		this.setSeq(this.getId());
	}
	/**
	 * 
	 * @param library - the personal domain of the user
	 * @param topic - the ID of the Biblical or Liturgical text
	 * @param key - date-time stamp
	 * @param note - the information the user wants to save as a note
	 */
	public TextualNote(
			String library
			, String topic
			, String key
			, String note
			) {
		super(
				library
				, topic
				, key
				, schema
				, version
				, ontoTopic
				);
		this.value = note;
		this.setSeq(this.getId());
	}

	/**
	 * Convenience constructor to copy
	 * an instance of the Create Form to an LTKDb instance
	 * @param form to copy from
	 */
	public TextualNote(
			UserNoteCreateForm form
			) {
		super(
				form.getLibrary()
				, form.getTopic()
				, form.getKey()
				, TextualNote.schema
				, TextualNote.version
				, TextualNote.ontoTopic
				);
		if (form.getKey().trim().length() == 0) {
			// the timestamp has not been set yet.
			this.setKey(Instant.now().toString());
		}
		this.setValue(form.getValue());		
		this.setSeq(this.getId());
	}

}
