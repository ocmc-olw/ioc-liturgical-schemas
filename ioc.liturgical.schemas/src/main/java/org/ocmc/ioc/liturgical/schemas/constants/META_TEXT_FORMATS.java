package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 *
 * Meta formats for text, based on the OCMC ShareLatex Liturgical Workstation styles.
 * Text colors can be one of: Black, Blue, or Red.
 * Text weight can be normal or bold
 * Text style can be normal or italics.
 * These can all be combined.
 * @author mac002
 *
 */
public enum META_TEXT_FORMATS {
TEXT_BLACK("Text Black","ltTextBlack")
, TEXT_BLACK_BOLD("Text Black Bold","ltTextBlackBold")
, TEXT_BLACK_ITALICS("Text Black Italics","ltTextBlackItalics")
, TEXT_BLACK_BOLD_ITALICS("Text Black Bold Italics","ltTextBlackBoldItalics")
, TEXT_BLUE("Text Blue","ltTextBlue")
, TEXT_BLUE_BOLD("Text Blue Bold","ltTextBlueBold")
, TEXT_BLUE_ITALICS("Text Blue Italics","ltTextBlueItalics")
, TEXT_BLUE_BOLD_ITALICS("Text Blue Bold Italics","ltTextBlueBoldItalics")
, TEXT_RED("Text Red","ltTextRed")
, TEXT_RED_BOLD("Text Red Bold","ltTextRedBold")
, TEXT_RED_ITALICS("Text Red Italics","ltTextRedItalics")
, TEXT_RED_BOLD_ITALICS("Text Red Bold Italics","ltTextRedBoldItalics")
;

	public String keyname = "";
	public String latex = "";
	
	private META_TEXT_FORMATS(
			String keyname
			, String latex
			) {
		this.keyname = keyname;
		this.latex = latex;
	}
	
	public static META_TEXT_FORMATS getTypeForName(String name) {
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
    		if (e.name().equals(name)) {
    			return e;
    		}
    	}
    	return null;
	}

	public static META_TEXT_FORMATS getTypeForKeyName(String name) {
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
    		if (e.keyname.equals(name)) {
    			return e;
    		}
    	}
    	return null;
	}

	public static META_TEXT_FORMATS getTypeForLatexName(String name) {
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
    		if (e.latex.equals(name)) {
    			return e;
    		}
    	}
    	return null;
	}

	public static String toLatexCommand(META_TEXT_FORMATS value) {
		return "\\" + value.latex;
	}
	
	/**
	 * Converts the enumeration a JsonArray of DropdownItems
	 * where the dropdown item's
	 * value = enum.name
	 * label = enum.keyname
	 * 
	 * @param includeAny if true will add to the top an object that is value=*, label=any
	 * @return a JsonArray of Dropdowns 
	 */
    public static JsonArray toDropdownJsonArray(boolean includeAny) {
    	JsonArray result = new JsonArray();
    	if (includeAny) {
        	result.add(new DropdownItem("Any","*").toJsonObject());
    	}
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
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
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
		
    public static List<DropdownItem> toDropdownBilList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
    
    public static String toCss(META_TEXT_FORMATS value) {
    	StringBuffer sb = new StringBuffer();
    	sb.append("span.");
    	sb.append(value.latex);
    	sb.append(" {\n");
    	switch (value) {
		case TEXT_BLACK:
			sb.append("\tcolor: black;\n");
			break;
		case TEXT_BLACK_BOLD:
			sb.append("\tcolor: black;\n");
		    sb.append("\tfont-weight: bold;\n");
			break;
		case TEXT_BLACK_BOLD_ITALICS:
			sb.append("\tcolor: black;\n");
		    sb.append("\tfont-weight: bold;\n");
		    sb.append("\tfont-style: italic;\n");
			break;
		case TEXT_BLACK_ITALICS:
			sb.append("\tcolor: black;\n");
		    sb.append("\tfont-style: italic;\n");
			break;
		case TEXT_BLUE:
			sb.append("\tcolor: blue;\n");
			break;
		case TEXT_BLUE_BOLD:
			sb.append("\tcolor: blue;\n");
		    sb.append("\tfont-weight: bold;\n");
			break;
		case TEXT_BLUE_BOLD_ITALICS:
			sb.append("\tcolor: blue;\n");
		    sb.append("\tfont-weight: bold;\n");
		    sb.append("\tfont-style: italic;\n");
			break;
		case TEXT_BLUE_ITALICS:
			sb.append("\tcolor: blue;\n");
		    sb.append("\tfont-style: italic;\n");
			break;
		case TEXT_RED:
			sb.append("\tcolor: red;\n");
			break;
		case TEXT_RED_BOLD:
		    sb.append("\tfont-weight: bold;\n");
			sb.append("\tcolor: red;\n");
			break;
		case TEXT_RED_BOLD_ITALICS:
		    sb.append("\tfont-weight: bold;\n");
		    sb.append("\tfont-style: italic;\n");
			sb.append("\tcolor: red;\n");
			break;
		case TEXT_RED_ITALICS:
			sb.append("\tcolor: red;\n");
		    sb.append("\tfont-style: italic;\n");
			break;
		default:
			sb.append("\tcolor: black;\n");
			break;
    	}
    	sb.append("}\n");
    	return sb.toString();
    }
    
    public static String toCss() {
    	StringBuffer sb = new StringBuffer();
    	for (META_TEXT_FORMATS e : META_TEXT_FORMATS.values()) {
    		sb.append(META_TEXT_FORMATS.toCss(e));
    	}
    	return sb.toString();
    }
}
