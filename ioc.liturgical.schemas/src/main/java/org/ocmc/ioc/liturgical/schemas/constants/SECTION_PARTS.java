package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 * Names of component parts for a section of a template used to 
 * generate a book or service.
 * 
 * Historical note: these correspond to the atem.xtext grammar file used to generate
 * the grammar, editor, and generator for the atem DSL in AGES Liturgical Workbench.
 * @author mac002
 *
 */
public enum SECTION_PARTS {
	ACTOR("Actor", "Actor")
	, DIALOG("Dialog", "Dialog")
	, HYMN("Hymn", "Hymn")
	, INSERT_SECTION("Insert_section", "Insert_section")
	, INSERT_TEMPLATE("Insert_template", "Insert_template")
	, PARAGRAPH("ParaGraph", "Paragraph")
	, READING("Reading", "Reading")
	, RUBRIC("Rubric", "Rubric")
	, SECTION("Section", "Section")
	, TEMPLATE("Template", "Template")	
	, TITLE("Title", "Title")	
	, VERSE("Verse", "Verse")
	, WHEN_DATE("WhenDate", "when-date-is")
	, WHEN_DAY_NAME("WhenDayName", "when-name-of-day-is")
	, WHEN_EXISTS("WhenExists", "when-exists")
	, WHEN_LUKAN_CYCLE_DAY("WhenLukanCycleDay", "when-Lukan-Cycle-Day-is")
	, WHEN_MODE_OF_WEEK("WhenModeOfWeek", "when-mode-of-week")
	, WHEN_PASCHA("WhenPascha", "when-pascha-is")
	, WHEN_MOVABLE_CYCLE_DAY("WhenMovableCycleDay", "when-movable-cycle-day-is")
	, WHEN_PENTECOSTARIAN_DAY("WhenPentecostarianDay", "when-pentecostarian-day-is")
	, WHEN_SUNDAY_AFTER_ELEVATION_OF_CROSS_DAY("WhenSundayAfterElevationOfCrossDay", "when-Sunday-after-elevation-of-cross-is")
	, WHEN_TRIODION_DAY("WhenTriodionDay", "when-triodion-day-is")
	, WHEN_SUNDAYS_BEFORE_TRIODION("WhenSundaysBeforeTriodion", "when-sundays-before-triodion")
	;

	public String keyname = "";
	public String fullname = "";
	
	private SECTION_PARTS(
			String keyname
			, String fullname
			) {
		this.keyname = keyname;
		this.fullname = fullname;
	}

	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return a JsonArray of Dropdowns
	 */
    public static JsonArray toDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (SECTION_PARTS e : SECTION_PARTS.values()) {
    		if (e != SECTION_PARTS.TEMPLATE) {
        		result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    		}
    	}
    	return result;
    }

	/**
	 * Converts the enumeration a List of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @return a list of dropdowns
	 */
    public static List<DropdownItem> toDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (SECTION_PARTS e : SECTION_PARTS.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

		
}
