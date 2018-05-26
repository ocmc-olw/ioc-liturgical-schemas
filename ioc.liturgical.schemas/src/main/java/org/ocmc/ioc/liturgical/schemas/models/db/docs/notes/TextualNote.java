package org.ocmc.ioc.liturgical.schemas.models.db.docs.notes;

import java.time.Instant;
import java.util.Comparator;
import java.util.regex.Pattern;

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
	private static Pattern punctPattern = Pattern.compile("[˙·,.;!?(){}\\[\\]<>%]"); // punctuation
	
	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The type of this note.")
	@Expose public NOTE_TYPES noteType = NOTE_TYPES.GENERAL;

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the liturgical Greek text referenced by this note.")
	@Expose public String liturgicalGreekId = "";

	@Attributes(id = "top", required = false, readonly = false, description = "The database ID of the liturgical Greek text referenced by this note.")
	@Expose public String liturgicalTranslationId = "";

	@Attributes(id = "top", required = true, readonly = false, minLength = 1, description = "The textual scope of this note.")
	@Expose public String liturgicalScope = ""; 
	
	private String liturgicalScopeNnp = "";
	
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
		this.liturgicalScope = liturgicalScope.trim();
		this.setTheLiturgicalScopeNnp();
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
	
	public String getTheLiturgicalScopeNnp() {
		if (this.liturgicalScopeNnp == null || this.liturgicalScopeNnp.length() == 0) {
			if (this.liturgicalScope != null && this.liturgicalScope.length() > 0) {
				this.setTheLiturgicalScopeNnp();
			}
		}
		return this.liturgicalScopeNnp;
	}
	
	public void setTheLiturgicalScopeNnp() {
		try {
			this.liturgicalScopeNnp = punctPattern.matcher(
					this.liturgicalScope.trim())
					.replaceAll("")
					.toLowerCase()
					;
		} catch (Exception e) {
			// ignore
		}
	}
	
	public static Comparator<TextualNote> noteLiturgicalLemmaComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				String topic1 = note1.getLiturgicalLemma();
				String topic2 = note2.getLiturgicalLemma();
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	public static Comparator<TextualNote> noteLiturgicalScopeComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				
				String topic1 = note1.getTheLiturgicalScopeNnp();
				String topic2 = note2.getTheLiturgicalScopeNnp();
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	public static Comparator<TextualNote> noteTypeLiturgicalScopeComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				String topic1 = note1.getNoteType().fullname + note1.getTheLiturgicalScopeNnp();
				String topic2 = note2.getNoteType().fullname + note2.getTheLiturgicalScopeNnp();
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	public static Comparator<TextualNote> noteTypeLiturgicalLemmaComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				String topic1 = note1.getNoteType() + note1.getLiturgicalLemma();
				String topic2 = note2.getNoteType() + note2.getLiturgicalLemma();
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	public static Comparator<TextualNote> noteTypeAdHocComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				String topic1 = "";
				String topic2 = "";
				if (note1.adhocSortKey.length() > 0 && note2.adhocSortKey.length() > 0) {
					topic1 = note1.getNoteType().fullname + note1.adhocSortKey;
					topic2 = note2.getNoteType().fullname + note2.adhocSortKey;
				} else {
					topic1 = note1.getNoteType().fullname + note1.getTheLiturgicalScopeNnp();
					topic2 = note2.getNoteType().fullname + note2.getTheLiturgicalScopeNnp();
				}
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
	public static Comparator<TextualNote> adHocComparator = new Comparator<TextualNote>() {
		public int compare(TextualNote note1, TextualNote note2) {
			try {
				String topic1 = note1.adhocSortKey;
				String topic2 = note2.adhocSortKey;
			      //ascending order
			      return topic1.compareTo(topic2);
			} catch (Exception e) {
				return 0;
			}
		}
	};
}
