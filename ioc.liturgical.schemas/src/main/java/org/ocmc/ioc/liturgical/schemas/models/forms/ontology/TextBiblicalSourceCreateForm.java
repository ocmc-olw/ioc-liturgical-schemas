package org.ocmc.ioc.liturgical.schemas.models.forms.ontology;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.ID_PART_TYPES;
import org.ocmc.ioc.liturgical.schemas.constants.TOPICS;
import org.ocmc.ioc.liturgical.schemas.models.supers.LTK;

import com.github.reinert.jjschema.Attributes;

/**
 * This class provides a POJO for use in web forms to create or update a domain
 * @author mac002
 *
 */
@Attributes(title = "Biblical Text (Source)", description = "Form to create a verse of a Biblical source text")
public class TextBiblicalSourceCreateForm extends LTK {

	private static double serialVersion = 1.1;
	private static String schema = TextBiblicalSourceCreateForm.class.getSimpleName();

	@UiWidget(Constants.UI_WIDGET_TEXTAREA)
	@Attributes(required = true, description = "The value of the text.")
	@Expose public String value = "";

	public TextBiblicalSourceCreateForm(
			String library
			, String topic
			, String key
			) {
		super(
				library
				, topic
				, key
				, schema
				, serialVersion
				, TOPICS.TEXT_BIBLICAL
				);
		this.partTypeOfTopic = ID_PART_TYPES.BIBLICAL_BOOK_ABBREVIATION;
		this.partTypeOfKey = ID_PART_TYPES.BIBLICAL_CHAPTER_VERSE;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
