package org.ocmc.ioc.liturgical.schemas.models;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

/**
 * Used to build a JsonObject to represent an item in a dropdown list.
 * @author mac002
 *
 */
public class DropdownItem extends AbstractModel {
	@Expose String label = "";
	@Expose String value = "";
	
	public DropdownItem() {
		super();
	}
	
	/**
	 * Shortcut constructor that sets both label and value to value parm
	 * @param value the value
	 */
	public DropdownItem(String value) {
		super();
		this.label = value;
		this.value = value;
	}

	/**
	 * 
	 * @param label the label
	 * @param value the value
	 */
	public DropdownItem(String label, String value) {
		super();
		this.label = label;
		this.value = value;
	}
	
	/**
	 * 
	 * @return the label for this dropdown item
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * 
	 * @param label the label part of the dropdown item
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	
	/**
	 * 
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * 
	 * @param value for this dropdown item
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
