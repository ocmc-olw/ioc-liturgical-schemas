package org.ocmc.ioc.liturgical.schemas.models.supers;

import com.google.gson.annotations.Expose;

import com.github.reinert.jjschema.Attributes;

/**
 * Superclass for temporary user interface forms.
 * 
 * The uiSchema order list will be generated from the get and set methods. 
 * So, if there are any methods that are not explicit property getters and setters
 * do not name them using get or set.  For example, getIdAsPath() had to be
 * renamed to toIdAsPath() so the uiSchema did not consider it to be a property.
 * 
 * How to control the order in which properties appear in the UI Schema:
 * 
 * 1. If id="top" is set in an attribute, it will 'float' to the top.
 * 2. If id='bottom' is set in an attribute, it will 'float' to the bottom.
 * 3. If id is not set, it will appear in the middle.
 * 4. The order in which they appear below is the order in which they will occur in the UI Schema in each section (top, middle, bottom).
  * @author mac002
 *
 */
@Attributes(title = "Class Name", description = "A {class name} {description}")
public class AbstractSchemaModel extends AbstractModel {
	@Attributes(id = "bottom", required = true, readonly = true, minLength = 1, description = "The unique identifier for the schema.")
	@Expose public String _valueSchemaId = "";
	
	public AbstractSchemaModel(
			String schema
			, double serialVersion
			) {
		super();
		this._valueSchemaId = schema + ":" + this.serialVersionUID;
	}

	public String get_valueSchemaId() {
		return _valueSchemaId;
	}

	public void set_valueSchemaId(String _valueSchemaId) {
		this._valueSchemaId = _valueSchemaId;
	}
	
}
