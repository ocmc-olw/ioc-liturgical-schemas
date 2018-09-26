package org.ocmc.ioc.liturgical.schemas.models.dictionary;

import com.google.gson.annotations.Expose;

import java.util.Comparator;

import org.jsoup.Jsoup;
import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.abbreviations.Abbreviation;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTKDb;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "LTKDbNote", description = "Abstract note Entry")
public class DictionaryEntry extends LTKDb  {
	private static String schema = DictionaryEntry.class.getSimpleName();
	private static double version = 1.1;
	private static TOPICS ontologyTopic = TOPICS.DICTIONARY_ENTRY;

	@Attributes(id="top", required = true, description = "The head is for a word or phrase you want people to use to find the entry in the dictionary.")
	@Expose public String entryHead = "";

	@Attributes(id="top", required = false, description = "Slot 1 is for a word or phrase you want to occur after the entry word, but before the text of the entry")
	@Expose public String slot1 = "";

	@Attributes(id="top", required = false, description = "Slot 2 is for a word or phrase you want to occur after slot 1, but before the text of the entry")
	@Expose public String slot2 = "";

		@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(id="top", required = false, description = "A text of the entry with formatting")
	@Expose public String entryTextFormatted = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(id="bottom", required = false, readonly=true, description = "The text with formatting removed")
	@Expose public String entryTextNoFormat = "";

	@Attributes(id="bottom", readonly=true, required = false, description = "Sequence.  Used for sort order when listing instances of notes.")
	@Expose public String seq = "";

	public DictionaryEntry(
			String key
			)  {
		super(
				Constants.LIBRARY_TRANS_LIB
				, Constants.TOPIC_DICTIONARY
				, key
				, schema
				,  version
				, ontologyTopic
				);
		this.seq = this.getId();
		this.setPartTypeOfTopic(ID_PART_TYPES.DICTIONARY_ENTRY);
		this.setPartTypeOfKey(ID_PART_TYPES.USER_TEXT);
	}

	public DictionaryEntry(
			DictionaryEntryCreateForm form
			) {
		super(
				form.getLibrary()
				, form.getTopic()
				, form.getKey()
				, schema
				,  version
				, ontologyTopic
				);
		this.entryHead = form.getEntryHead();
		this.slot1 = form.getSlot1();
		this.slot2 = form.getSlot2();
		this.entryTextFormatted  = form.getEntryText();
		try {
			this.entryTextNoFormat = Jsoup.parse(this.entryTextFormatted).text();
		} catch (Exception e) {
			this.entryTextNoFormat = this.entryTextFormatted;
		}
		this.seq = this.getId();
		this.setPartTypeOfTopic(ID_PART_TYPES.DICTIONARY_ENTRY);
		this.setPartTypeOfKey(ID_PART_TYPES.USER_TEXT);
	}


		public static Comparator<DictionaryEntry> noteTopicComparator = new Comparator<DictionaryEntry>() {
		public int compare(DictionaryEntry note1, DictionaryEntry note2) {
			String topic1 = note1.getTopic();
			String topic2 = note2.getTopic();
		      
		      //ascending order
		      return topic1.compareTo(topic2);
		    }
		};
		public static Comparator<DictionaryEntry> noteTopicComparatorDesc = new Comparator<DictionaryEntry>() {
			public int compare(DictionaryEntry note1, DictionaryEntry note2) {
		    	
				String topic1 = note1.getTopic();
				String topic2 = note2.getTopic();
			      
			      //descending order
			      return topic2.compareTo(topic1);
			    }
			};

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

		public String getEntryTextFormatted() {
			return entryTextFormatted;
		}

		public void setEntryTextFormatted(String entryTextFormatted) {
			this.entryTextFormatted = entryTextFormatted;
		}

		public String getEntryTextNoFormat() {
			return entryTextNoFormat;
		}

		public void setEntryTextNoFormat(String entryTextNoFormat) {
			this.entryTextNoFormat = entryTextNoFormat;
		}

		public String getSeq() {
			return seq;
		}

		public void setSeq(String seq) {
			this.seq = seq;
		}

}
