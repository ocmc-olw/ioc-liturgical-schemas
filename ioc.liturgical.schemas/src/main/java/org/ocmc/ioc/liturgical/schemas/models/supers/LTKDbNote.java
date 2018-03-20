package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import org.jsoup.Jsoup;
import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "LTKDbNote", description = "Abstract note Entry")
public class LTKDbNote extends LTKDb {

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(id="top", required = false, description = "A note made about the text by a user, with formatting removed")
	@Expose public String value = "";

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(id="top", required = false, description = "A formatted note made about the text by a user")
	@Expose public String valueFormatted = "";

	@Attributes(id="bottom", readonly=true, required = false, description = "Sequence.  Used for sort order when listing instances of notes.")
	@Expose public String seq = "";

	public LTKDbNote(
			String library
			, String topic
			, String key
			, String schema
			, double serialVersion
			, TOPICS ontologyTopic
			) {
		super(
				library
				, topic
				, key
				, schema
				,  serialVersion
				, ontologyTopic
				);
		this.seq = this.getId();
	}

	public LTKDbNote(
			String schema
			, double serialVersion
			, TOPICS topic
			, LTKNoteCreateForm form
			) {
		super(
				form.getLibrary()
				, form.getTopic()
				, form.getKey()
				, schema
				,  serialVersion
				, topic
				);
		this.value = form.value;
		this.seq = this.getId();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		try {
			this.value = Jsoup.parse(value).text();
		} catch (Exception e) {
			this.value = value;
		}
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getValueFormatted() {
		return valueFormatted;
	}

	public void setValueFormatted(String valueFormatted) {
		this.valueFormatted = valueFormatted;
		this.setValue(valueFormatted);
	}


}
