package org.ocmc.ioc.liturgical.schemas.models.db.docs.personal;

import java.time.Instant;

import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.forms.ontology.UserNoteCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDbNote;

import com.github.reinert.jjschema.Attributes;

@Attributes(title = "User Note (Private)", description = "This form allows you to enter or read private notes you make about the text shown above.")
public class UserNote extends LTKDbNote {
	
	private static String schema = UserNote.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontoTopic = TOPICS.NOTE_USER;
	
	/**
	 * 
	 * @param library - the personal domain of the user
	 * @param topic - the ID of the Biblical or Liturgical text
	 * @param key - date-time stamp
	 */
	public UserNote(
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
	public UserNote(
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
	public UserNote(
			UserNoteCreateForm form
			) {
		super(
				form.getLibrary()
				, form.getTopic()
				, form.getKey()
				, UserNote.schema
				, UserNote.version
				, UserNote.ontoTopic
				);
		if (form.getKey().trim().length() == 0) {
			// the timestamp has not been set yet.
			this.setKey(Instant.now().toString());
		}
		this.setValue(form.getValue());		
		this.setSeq(this.getId());
	}

}
