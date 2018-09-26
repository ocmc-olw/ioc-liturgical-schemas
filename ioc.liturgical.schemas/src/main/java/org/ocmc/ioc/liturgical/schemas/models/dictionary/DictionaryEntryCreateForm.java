package org.ocmc.ioc.liturgical.schemas.models.dictionary;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.SCHEMA_CLASSES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTK;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Dictionary Entry Create Form", description = "Ab Form to Create a Dictionary Entry")
public class DictionaryEntryCreateForm extends LTK {
	private static String schema = DictionaryEntryCreateForm.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontologyTopic = TOPICS.DICTIONARY_ENTRY;

	@Attributes(id="top", readonly=true, required = true, description = "The head is for a word or phrase you want people to use to find the entry in the dictionary.")
	@Expose public String entryHead = "";

	@Attributes(id="top", readonly=true, required = false, description = "Slot 1 is for a word or phrase you want to occur after the entry word, but before the text of the entry")
	@Expose public String slot1 = "";

	@Attributes(id="top", readonly=true, required = false, description = "Slot 2 is for a word or phrase you want to occur after slot 1, but before the text of the entry")
	@Expose public String slot2 = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(id="top", required = false, description = "The text of your entry")
	@Expose public String entryText = "";

	@Attributes(id="bottom", readonly=true, required = false, description = "Sequence.  Used for sort order when listing instances of notes.")
	@Expose public String seq = "";

	public DictionaryEntryCreateForm(
			String key
			) {
		super(
				Constants.LIBRARY_TRANS_LIB
				, Constants.TOPIC_DICTIONARY
				, key
				, schema
				,  version
				, ontologyTopic
				);
		this.seq = super.getId();
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getEntryHead() {
		return entryHead;
	}

	public void setEntryHead(String entryHead) {
		this.entryHead = entryHead;
	}

	public String getSlot1() {
		return slot1;
	}

	public void setSlot1(String slot1) {
		this.slot1 = slot1;
	}

	public String getSlot2() {
		return slot2;
	}

	public void setSlot2(String slot2) {
		this.slot2 = slot2;
	}

	public String getEntryText() {
		return entryText;
	}

	public void setEntryText(String entryText) {
		this.entryText = entryText;
	}

}
