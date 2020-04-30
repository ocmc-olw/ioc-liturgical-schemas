package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;

import com.google.gson.JsonArray;

/**
 * Names of component parts for a section of a template used to 
 * generate a book or service.
 * 
 * Historical note: these correspond to the atem.xtext grammar file used to generate
 * the grammar, editor, and generator for the atem DSL in AGES Liturgical Workbench.
 * 
 * Also, because Java does not allow enums to be extended (subclassed), the
 * enums here are a mixed bag.  Hence the various dropdown methods.
 * 
 * @author mac002
 *
 */
public enum TEMPLATE_NODE_TYPES {
	Actor("Actor", "Actor", "TextRed", "TextRed", "TextRed", "TextRed")
	, ActorDialog("ActorDialog", "ActorDialog", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, ActorDialogAloud("ActorDialogAloud", "ActorDialogAloud", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, ActorDialogLowVoice("ActorDialogLowVoice", "ActorDialogLowVoice", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, ActorDialogLowVoiceRubric("ActorDialogLowVoiceRubric", "ActorDialogLowVoiceRubric", "TextRed", "TextBlack", "TextRed", "TextRed")
	, ActorDialogRubric("ActorDialogRubric", "ActorDialogRubric", "TextBlack", "TextRed", "TextRed", "TextRed")
	, ActorDialogRubricDialog("ActorDialogRubricDialog", "ActorDialogRubricDialog", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, ActorHymn("ActorHymn", "ActorHymn", "TextRed", "TextBlack}", "TextBlack}", "TextBlack}")
	, ActorHymnHymnRubric("ActorHymnHymnRubric", "ActorHymnHymnRubric", "TextRed", "TextRed", "TextRed", "TextRed")
	, ActorHymnRubric("ActorHymnRubric", "ActorHymnRubric", "TextBlack", "TextRed", "TextRed", "TextRed")
	, ActorReading("ActorReading", "ActorReading", "TextRed", "TextBlack}", "TextBlack}", "TextBlack}")
	, ActorRubric("ActorRubric", "ActorRubric", "TextRed", "TextRed", "TextRed", "TextRed")
	, ActorRubricDialog("ActorRubricDialog", "ActorRubricDialog", "TextRed", "TextRed", "TextBlack", "TextBlack")
	, ActorRubricDialogRubric("ActorRubricDialogRubric", "ActorRubricDialogRubric", "TextRed", "TextRed", "TextRed", "TextRed")
	, ActorRubricHymn("ActorRubricHymn", "ActorRubricHymn", "TextRed", "TextRed", "TextBlack", "TextBlack")
	, ActorRubricHymnRubric("ActorRubricHymnRubric", "ActorRubricHymnRubric", "TextRed", "TextRed", "TextRed", "TextRed")
	, Designation("Designation", "Designation", "TextRedItalics", "TextRedItalics", "TextRedItalics", "TextRedItalics")
	, Dialog("Dialog", "Dialog", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, DialogAloud("DialogAloud", "DialogAloud", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, DialogLowVoice("DialogLowVoice", "DialogLowVoice", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, DialogRubric("DialogRubric", "DialogRubric", "TextBlack", "TextBlack", "TextBlack", "TextRed")
	, DialogRubricDialog("DialogRubricDialog", "DialogRubricDialog", "TextBlack", "TextRed", "TextBlack", "TextBlack")
	, Heirmos("Heirmos", "Heirmos", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, Hymn("Hymn", "Hymn", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, HymnLastLine("HymnLastLine", "HymnLastLine", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, HymnRubric("HymnRubric", "HymnRubric", "TextBlack", "TextBlack", "TextBlack", "TextRed")
	, MixedDesignation("MixedDesignation", "MixedDesignation", "TextRed", "TextRed", "TextRedItalics", "TextRedItalics")
	, MixedDesignationDesignation("MixedDesignationDesignation", "MixedDesignationDesignation", "TextBlack", "TextRed", "TextRedItalics", "TextRedItalics")
	, MixedMode("MixedMode", "MixedMode", "TextBlack", "TextRedItalics", "TextRedItalics", "TextRedItalics")
	, MixedModeDesignation("MixedModeDesignation", "MixedModeDesignation", "TextBlack", "TextRed", "TextRedItalics", "TextRedItalics")
	, ModeMelody("ModeMelody", "ModeMelody", "TextRed", "TextRedItalics", "TextRedItalics", "TextRedItalics")
	, Paragraph("Paragraph", "Paragraph", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, Reading("Reading", "Reading", "TextBlack", "TextBlack", "TextBlack", "TextBlack")
	, RedItalics("RedItalics", "RedItalics", "TextRedItalics", "TextRedItalics", "TextRedItalics", "TextRedItalics")
	, Rubric("Rubric", "Rubric", "TextRed", "TextRed", "TextRed", "TextRed")
	, RubricDialog("RubricDialog", "RubricDialog", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, RubricDialogAloud("RubricDialogAloud", "RubricDialogAloud", "TextRed", "TextRed", "TextBlack", "TextBlack")
	, RubricDialogLowVoice("RubricDialogLowVoice", "RubricDialogLowVoice", "TextRed", "TextRed", "TextBlack", "TextBlack")
	, RubricDialogRubric("RubricDialogRubric", "RubricDialogRubric", "TextRed", "TextBlack", "TextRed", "TextRed")
	, RubricDialogRubricDialog("RubricDialogRubricDialog", "RubricDialogRubricDialog", "TextRed", "TextBlack", "TextRed", "TextBlack")
	, RubricHymn("RubricHymn", "RubricHymn", "TextRed", "TextBlack", "TextBlack", "TextBlack")
	, Stichos("Stichos", "Stichos", "TextRed", "TextBlack", "TextBlack", "TextRed")
	, Verse("Verse", "Verse", "TextBlack", "TextBlack", "TextBlack", "TextBlack")


	 , WHEN_DATE_IS("WhenDate", "when-date-is","","","","")
	, WHEN_DAY_NAME_IS("WhenDayName", "when-name-of-day-is","","","","")
	, WHEN_DAY_OF_MONTH_IS("WhenDayOfMonth", "when-day-of-month-is","","","","")
	, WHEN_EXISTS("WhenExists", "when-exists","","","","")
	, WHEN_LUKAN_CYCLE_DAY_IS("WhenLukanCycleDay", "when-Lukan-Cycle-Day-is","","","","")
	, WHEN_MONTH_NAME_IS("WhenMonth", "when-month-is","","","","")
	, WHEN_MODE_OF_WEEK_IS("WhenModeOfWeek", "when-mode-of-week","","","","")
	, WHEN_PASCHA("WhenPascha", "when-pascha-is","","","","")
	, WHEN_MOVABLE_CYCLE_DAY_IS("WhenMovableCycleDay", "when-movable-cycle-day-is","","","","")
	, WHEN_PENTECOSTARIAN_DAY_IS("WhenPentecostarianDay", "when-pentecostarian-day-is","","","","")
	, WHEN_SUNDAY_AFTER_ELEVATION_OF_CROSS_DAY_IS("WhenSundayAfterElevationOfCrossDay", "when-Sunday-after-elevation-of-cross-is","","","","")
	, WHEN_TRIODION_DAY_IS("WhenTriodionDay", "when-triodion-day-is","","","","")
	, WHEN_SUNDAYS_BEFORE_TRIODION("WhenSundaysBeforeTriodion", "when-sundays-before-triodion","","","","")
	, SUNDAY("D1","Sunday use","","","","")
	, MONDAY("D2","Monday use","","","","")
	, TUESDAY("D3","Tuesday use","","","","")
	, WEDNESDAY("D4","Wednesday use","","","","")
	, THURSDAY("D5","Thursday use","","","","")
	, FRIDAY("D6","Friday use","","","","")
	, SATURDAY("D7","Saturday use","","","","")
	, OTHERWISE("Otherwise","otherwise use","","","","")
	, DAY_01("D01", "Day 01","","","","")
	, DAY_02("D02", "Day 02","","","","")
	, DAY_03("D03", "Day 03","","","","")
	, DAY_04("D04", "Day 04","","","","")
	, DAY_05("D05", "Day 05","","","","")
	, DAY_06("D06", "Day 06","","","","")
	, DAY_07("D07", "Day 07","","","","")
	, DAY_08("D08", "Day 08","","","","")
	, DAY_09("D09", "Day 09","","","","")
	, DAY_10("D10", "Day 10","","","","")
	, DAY_11("D11", "Day 11","","","","")
	, DAY_12("D12", "Day 12","","","","")
	, DAY_13("D13", "Day 13","","","","")
	, DAY_14("D14", "Day 14","","","","")
	, DAY_15("D15", "Day 15","","","","")
	, DAY_16("D16", "Day 16","","","","")
	, DAY_17("D17", "Day 17","","","","")
	, DAY_18("D18", "Day 18","","","","")
	, DAY_19("D19", "Day 19","","","","")
	, DAY_20("D20", "Day 20","","","","")
	, DAY_21("D21", "Day 21","","","","")
	, DAY_22("D22", "Day 22","","","","")
	, DAY_23("D23", "Day 23","","","","")
	, DAY_24("D24", "Day 24","","","","")
	, DAY_25("D25", "Day 25","","","","")
	, DAY_26("D26", "Day 26","","","","")
	, DAY_27("D27", "Day 27","","","","")
	, DAY_28("D28", "Day 28","","","","")
	, DAY_29("D29", "Day 29","","","","")
	, DAY_30("D30", "Day 30","","","","")
	, DAY_31("D31", "Day 31","","","","")
	, DAY_32("D32", "Day 32","","","","")
	, DAY_33("D33", "Day 33","","","","")
	, DAY_34("D34", "Day 34","","","","")
	, DAY_35("D35", "Day 35","","","","")
	, DAY_36("D36", "Day 36","","","","")
	, DAY_37("D37", "Day 37","","","","")
	, DAY_38("D38", "Day 38","","","","")
	, DAY_39("D39", "Day 39","","","","")
	, DAY_40("D40", "Day 40","","","","")
	, DAY_41("D41", "Day 41","","","","")
	, DAY_42("D42", "Day 42","","","","")
	, DAY_43("D43", "Day 43","","","","")
	, DAY_44("D44", "Day 44","","","","")
	, DAY_45("D45", "Day 45","","","","")
	, DAY_46("D46", "Day 46","","","","")
	, DAY_47("D47", "Day 47","","","","")
	, DAY_48("D48", "Day 48","","","","")
	, DAY_49("D49", "Day 49","","","","")
	, DAY_50("D50", "Day 50","","","","")
	, DAY_51("D51", "Day 51","","","","")
	, DAY_52("D52", "Day 52","","","","")
	, DAY_53("D53", "Day 53","","","","")
	, DAY_54("D54", "Day 54","","","","")
	, DAY_55("D55", "Day 55","","","","")
	, DAY_56("D56", "Day 56","","","","")
	, DAY_57("D57", "Day 57","","","","")
	, DAY_58("D58", "Day 58","","","","")
	, DAY_59("D59", "Day 59","","","","")
	, DAY_60("D60", "Day 60","","","","")
	, DAY_61("D61", "Day 61","","","","")
	, DAY_62("D62", "Day 62","","","","")
	, DAY_63("D63", "Day 63","","","","")
	, DAY_64("D64", "Day 64","","","","")
	, DAY_65("D65", "Day 65","","","","")
	, DAY_66("D66", "Day 66","","","","")
	, DAY_67("D67", "Day 67","","","","")
	, DAY_68("D68", "Day 68","","","","")
	, DAY_69("D69", "Day 69","","","","")
	, DAY_70("D70", "Day 70","","","","")
    , MODE_1("M1", "Mode 1 (Ἦχος αʹ)","","","","")
    , MODE_2("M2", "Mode 2 (Ἦχος βʹ)","","","","")
    , MODE_3("M3", "Mode 3 (Ἦχος γʹ)","","","","")
    , MODE_4("M4", "Mode 4 (Ἦχος δʹ)","","","","")
    , MODE_5("M5", "Mode 5 (Ἦχος πλ. αʹ)","","","","")
    , MODE_6("M6", "Mode 6 (Ἦχος πλ. βʹ)","","","","")
    , MODE_7("M7", "Mode 7 (Ἦχος βαρύς)","","","","")
    , MODE_8("M8", "Mode 8 (Ἦχος πλ. δʹ)","","","","")
	, JAN("Jan", "January","","","","")
	, FEB("Feb", "February","","","","")
	, MAR("Mar", "March","","","","")
	, APR("Apr", "April","","","","")
	, MAY("May", "May","","","","")
	, JUN("Jun", "June","","","","")
	, JUL("Jul", "July","","","","")
	, AUG("Aug", "August","","","","")
	, SEP("Sep", "September","","","","")
	, OCT("Oct", "October","","","","")
	, NOV("Nov", "November","","","","")
	, DEC("Dec", "December","","","","")	
	, CHAPTER("Chapter","Chapter","","","","")
	, SECTION("Section","Section","","","","")
	, SUB_SECTION("SubSection","SubSection","","","","")
	, SUB_SUB_SECTION("SubSubSection","SubSubSection","","","","")
	, INSERT_TEMPLATE("Insert_Template","Insert_Template","","","","")
	, INSERT_SECTION("Insert_Section","Insert_Section","","","","")
	, TEMPLATE("Template","Template","","","","")
	, SID("SID","Specific ID","","","","")
	, RID("RID","Relative ID","","","","")
	,TITLE("Title","Title","","","","")
	;

	public String keyname = "";
	public String fullname = "";
	public String fmt0 = "";
	public String fmt1 = "";
	public String fmt2 = "";
	public String fmt3 = "";
	
	
	private TEMPLATE_NODE_TYPES(
			String keyname
			, String fullname
			, String fmt0
			, String fmt1
			, String fmt2
			, String fmt3
			) {
		this.keyname = keyname;
		this.fullname = fullname;
		this.fmt0 = fmt0;
		this.fmt1 = fmt1;
		this.fmt2 = fmt2;
		this.fmt3 = fmt3;
	}

	public static boolean childIsSubDivision(
			TEMPLATE_NODE_TYPES parent
			, TEMPLATE_NODE_TYPES child
			) {
		boolean result = false;
		switch (parent) {
		case CHAPTER:
			switch (child) {
			case SECTION:
			case SUB_SECTION:
			case SUB_SUB_SECTION: {
				result = true;
				break;
			}
			default:
				break;
			}
			break;
		case INSERT_SECTION:
			break;
		case INSERT_TEMPLATE:
			break;
		case SECTION:
			switch (child) {
			case SUB_SECTION:
			case SUB_SUB_SECTION: {
				result = true;
				break;
			}
			default:
				break;
			}
			break;
		case SUB_SECTION:
			switch (child) {
			case SUB_SUB_SECTION: {
				result = true;
				break;
			}
			default:
				break;
			}
			break;
		case SUB_SUB_SECTION:
			break;
		case TEMPLATE:
			result = true;
			break;
		default:
			break;
		}
		return result;
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
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		if (e != TEMPLATE_NODE_TYPES.TEMPLATE) {
        		result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    		}
    	}
    	return result;
    }

    public static List<TEMPLATE_NODE_TYPES> getModes() {
    	List<TEMPLATE_NODE_TYPES> result = new ArrayList<TEMPLATE_NODE_TYPES>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		if (e.fullname.startsWith("Mode")) {
        		result.add(e);
    		}
    	}
		result.add(OTHERWISE);
    	return result;
    }

    public static JsonArray toModesDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (TEMPLATE_NODE_TYPES e : getModes()) {
        		result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    	}
    	return result;
    }

    public static List<TEMPLATE_NODE_TYPES> getDaysOfMonth() {
    	List<TEMPLATE_NODE_TYPES> result = new ArrayList<TEMPLATE_NODE_TYPES>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		if (e.fullname.startsWith("Day")) {
    			int day = Integer.parseInt(e.fullname.substring(4));
    			if (day < 32) {
            		result.add(e);
    			}
    		}
    	}
		result.add(OTHERWISE);
    	return result;
    }


    public static JsonArray toDaysOfMonthDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (TEMPLATE_NODE_TYPES e : getDaysOfMonth()) {
           result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    	}
    	return result;
    }

    public static List<TEMPLATE_NODE_TYPES> getDaysOfSeason() {
    	List<TEMPLATE_NODE_TYPES> result = new ArrayList<TEMPLATE_NODE_TYPES>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		if (e.fullname.startsWith("Day")) {
            		result.add(e);
    		}
    	}
		result.add(OTHERWISE);
    	return result;
    }

    public static JsonArray toDaysOfSeasonDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (TEMPLATE_NODE_TYPES e : getDaysOfSeason()) {
    			result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    	}
    	return result;
    }

    public static List<TEMPLATE_NODE_TYPES> getMonths() {
    	List<TEMPLATE_NODE_TYPES> result = new ArrayList<TEMPLATE_NODE_TYPES>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
        		switch (e) {
    			case JAN:
            		result.add(e);
    				break;
    			case FEB:
            		result.add(e);
    				break;
    			case MAR:
            		result.add(e);
    				break;
    			case APR:
            		result.add(e);
    				break;
    			case MAY:
            		result.add(e);
    				break;
    			case JUN:
            		result.add(e);
    				break;
    			case JUL:
            		result.add(e);
    				break;
    			case AUG:
            		result.add(e);
    				break;
    			case SEP:
            		result.add(e);
    				break;
    			case OCT:
            		result.add(e);
    				break;
    			case NOV:
            		result.add(e);
    				break;
    			case DEC:
            		result.add(e);
    				break;
    			default:
    				break;
        		}
        	}
    	result.add(OTHERWISE);
    	return result;
    }

    public static JsonArray toMonthsDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (TEMPLATE_NODE_TYPES e : getMonths()) {
        		result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
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
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		result.add(new DropdownItem(e.keyname, e.name()));
    	}
    	return result;
    }

    public static JsonArray toNewTemplateDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (DropdownItem e : toNewTemplateDropdownList()) {
        		result.add(e.toJsonObject());
    	}
    	return result;
    }
    
    public static List<DropdownItem> toNewTemplateDropdownList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		switch (e) {
			case SECTION:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case SID:
				break;
			case TEMPLATE:
				break;
			case TITLE:
				break;
			case Verse:
				break;
			case WHEN_DATE_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_DAY_NAME_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_DAY_OF_MONTH_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_EXISTS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_LUKAN_CYCLE_DAY_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_MODE_OF_WEEK_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_MOVABLE_CYCLE_DAY_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_PASCHA:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_PENTECOSTARIAN_DAY_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_SUNDAYS_BEFORE_TRIODION:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_SUNDAY_AFTER_ELEVATION_OF_CROSS_DAY_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			case WHEN_TRIODION_DAY_IS:
	    		result.add(new DropdownItem(e.keyname, e.name()));
				break;
			default:
				break;
    		}
    	}
    	return result;
    }
    
    public static List<TEMPLATE_NODE_TYPES> getDaysOfWeek() {
    	List<TEMPLATE_NODE_TYPES> result = new ArrayList<TEMPLATE_NODE_TYPES>();
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
        		switch (e) {
    			case SUNDAY:
    	    		result.add(e);
    				break;
    			case MONDAY:
    	    		result.add(e);
    				break;
    			case TUESDAY:
    	    		result.add(e);
    				break;
    			case WEDNESDAY:
    	    		result.add(e);
    				break;
    			case THURSDAY:
    	    		result.add(e);
    				break;
    			case FRIDAY:
    	    		result.add(e);
    				break;
    			case SATURDAY:
    	    		result.add(e);
    				break;
    			case OTHERWISE:
    	    		result.add(e);
    				break;
    			default:
    				break;
        	}
    	}
    	return result;
    }

    public static JsonArray toDaysOfWeekDropdownJsonArray() {
    	JsonArray result = new JsonArray();
    	for (TEMPLATE_NODE_TYPES e : getDaysOfWeek()) {
           result.add(new DropdownItem(e.keyname, e.name()).toJsonObject());
    	}
    	return result;
    }

    public static TEMPLATE_NODE_TYPES typeForName(String name) {
    	TEMPLATE_NODE_TYPES result = null;
    	for (TEMPLATE_NODE_TYPES e : TEMPLATE_NODE_TYPES.values()) {
    		if (e.keyname.equals(name)) {
    			result = e;
    			break;
    		}
    	}
    	return result;
    }


    /**
     * 
     * @return true if this enum requires using the TemplateNode subtitle as a lookup ID
     */
    public boolean subtitleIsLookup() {
    	boolean result = false;
    	switch (this) {
		case INSERT_SECTION:
			result = true;
			break;
		case INSERT_TEMPLATE:
			result = true;
			break;
		case RID:
			result = true;
			break;
		case SID:
			result = true;
			break;
		default:
			break;
    	}
    	return result;
    }

		
}
