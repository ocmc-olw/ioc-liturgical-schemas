package org.ocmc.ioc.liturgical.schemas.constants;

import java.util.ArrayList;
import java.util.List;

import org.ocmc.ioc.liturgical.schemas.models.DropdownItem;

import com.google.gson.JsonArray;

/**
 *
 * Meta sizes for text, based on LaTeX.
 * When used in LaTeX, they increase or decrease the size relative to the document point size.
 * @author mac002
 *
 */
public enum META_TEXT_SIZES {
EM25("2.5em","\\Huge","ltEm25")
, EM20("2.0em","\\huge","ltEm20")
, EM17("1.7em","\\LARGE","ltEm17")
, EM14("1.4em","\\Large","ltEm14")
, EM12("1.2em","\\large","ltEm12")
, EM10("1.0em","\\normalsize","ltEm10")
, EM09("0.9em","\\small","ltEm09")
, EM08("0.8em","\\footnotesize","ltEm08")
, EM07("0.7em","\\scriptsize","ltEm07")
, EM05("0.5em", "\\tiny","ltEm05")
;

	public String cssValue = "";
	public String latex = "";
	public String cssClassName = "";
	
	private META_TEXT_SIZES(
			String keyname
			, String latex
			, String css
			) {
		this.cssValue = keyname;
		this.latex = latex;
		this.cssClassName = css;
	}
	
	public static META_TEXT_SIZES getTypeForName(String name) {
    	for (META_TEXT_SIZES e : META_TEXT_SIZES.values()) {
    		if (e.name().equals(name)) {
    			return e;
    		}
    	}
    	return null;
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
    	for (META_TEXT_SIZES e : META_TEXT_SIZES.values()) {
    		result.add(new DropdownItem(e.latex, e.name()).toJsonObject());
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
    	for (META_TEXT_SIZES e : META_TEXT_SIZES.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
		
    public static List<DropdownItem> toDropdownBilList() {
    	List<DropdownItem> result = new ArrayList<DropdownItem>();
    	for (META_TEXT_SIZES e : META_TEXT_SIZES.values()) {
        		result.add(new DropdownItem(e.latex, e.name()));
    	}
    	return result;
    }
    
    public static String toCss(META_TEXT_SIZES value) {
    	StringBuffer sb = new StringBuffer();
    	sb.append("span.");
    	sb.append(value.cssClassName);
    	sb.append(" {\n\tfont-size:");
        sb.append(value.cssValue);
    	sb.append(";\n");
    	sb.append("}\n");
    	return sb.toString();
    }
    
    public static String toCss() {
    	StringBuffer sb = new StringBuffer();
    	for (META_TEXT_SIZES e : META_TEXT_SIZES.values()) {
    		sb.append(META_TEXT_SIZES.toCss(e));
    	}
    	return sb.toString();
    }


}
