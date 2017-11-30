package org.ocmc.ioc.liturgical.schemas.models.supers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONException;
import org.json.JSONObject;
import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.NEW_FORM_CLASSES_DB_API;
import org.ocmc.ioc.liturgical.schemas.models.exceptions.SchemaException;
import org.ocmc.ioc.liturgical.schemas.models.exceptions.SchemaExceptionDescription;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.WsPaths;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.reinert.jjschema.Attributes;
import com.github.reinert.jjschema.v1.JsonSchemaFactory;
import com.github.reinert.jjschema.v1.JsonSchemaV4Factory;

/**
 * Important! Any class that implements this must 
 * 1. have a parameterless contructor that calls super().  
 * Otherwise, gson will be null for the subclass.
 * 
 * 2. set serialVersionUID.
 * 
 * @author mac002
 *
 */
public class AbstractModel {
    private static final Logger logger = LoggerFactory.getLogger(AbstractModel.class);
	protected double serialVersionUID = 1.1;

	public static Gson gson = new GsonBuilder()
			.excludeFieldsWithoutExposeAnnotation()
			.create();
	
	public AbstractModel() {
	}

	public void disableHtmlEscaping() {
		gson = new GsonBuilder()
				.disableHtmlEscaping()
				.excludeFieldsWithoutExposeAnnotation()
				.create();
	}
	
	/**
	 * Used to get an instance from a json string.
	 * You must first instantiate some subclass, then
	 * call this method on it.
	 * 
	 * For example,
	 * 
	 * String json = "{\"name\":\"S2\",\"url\":\"http://www.somewhere.com\",\"_id\":\"servers|S2\"}"
	 * Server entry = new Server(); // where server is some subclass of AbstractModel
	 * entry = (Server) entry.fromJsonString(json);
	 * @param json to be converted to an AbstractModel
	 * @return the AbstractModel from the json string
	 */
	public AbstractModel fromJsonString(String json) {
		try {
			return gson.fromJson(json, this.getClass());
		} catch (Exception e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @return the AbstractModel instance as a json string
	 */
	public String toJsonString() {
		String result = null;
		try {
			result = AbstractModel.gson.toJson(this);
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
			result = null;
		}
		return result;
	}
	
	public JsonObject toJsonObject() {
		JsonObject result = null;
		try {
			result = (new JsonParser()).parse(toJsonString()).getAsJsonObject();
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
			result = null;
		}
		return result;
	}

	public String toJsonSchema() {
		return toJsonSchema(this.getClass());
	}
	
	public String toJsonSchema(@SuppressWarnings("rawtypes") Class theClass) {
		JsonSchemaFactory schemaFactory = new JsonSchemaV4Factory();
		schemaFactory.setAutoPutDollarSchema(true);
		JsonNode productSchema = schemaFactory.createSchema(theClass);
		return productSchema.toString();
	}

	public JsonObject toJsonSchemaObject() {
		return toJsonSchemaObject(this.getClass());
	}

	public JsonObject toJsonSchemaObject(@SuppressWarnings("rawtypes") Class theClass) {
		JsonSchemaFactory schemaFactory = new JsonSchemaV4Factory();
		JsonNode productSchema = null;
		try {
			productSchema = schemaFactory.createSchema(theClass);
			return new JsonParser().parse(productSchema.toString()).getAsJsonObject();
		} catch (Exception e) {
			ErrorUtils.report(logger, e, "Class = " + theClass.getCanonicalName());
		}
		return null;
	}
		
	/**
	 * Is the json string valid per its schema
	 * @param json to be validated
	 * @return true if valid
	 */
	public boolean valid(String json) {
		return validate(json).length() == 0;
	}
	
	/**
	 * Check the json string to see if it is valid per its schema
	 * @param json to be checked
	 * @return true if valid
	 */
	public String validate(String json) {
		String result = "";
		try {
			JSONObject rawSchema = new JSONObject(toJsonSchema());
			Schema schema = SchemaLoader.load(rawSchema);
			schema.validate(new JSONObject(json));
		} catch (ValidationException e) {
			result = e.toJSON().toString();
		} catch (JSONException e) {
			SchemaExceptionDescription sem = new SchemaExceptionDescription(
					"json"
					, ""
					, "valid json"
					, "missing or invalid json"
					);
			SchemaException se = new SchemaException(
					"/"
					, "valid json"
					, sem.toString()
					);
			result = se.toJsonString();
		}
		return result;
	}
	
	/**
	 * Get a json string for react-jsonschema-form that is the ui-schema.
	 * 
	 * This will include the uiOrder.  The order in the form is based on the order
	 * in which the fields occur in the Java class.  Only fields that have the Expose
	 * annotation will be included.
	 * 
	 * @return the json string for react-jsonschema-form that is the ui-schema
	 */
	public String toUiSchema() {
		return toJsonUiSchemaObject().toString();
	}
	
	/**
	 * To be included in the UiSchema, the following conditions must be met
	 * for a subclass:
	 * - it must use the Attributes annotation
	 * - it must use the {@literal}Expose attribute
	 * - it must be a public property
	 * 
	 * Example:
	 * {@literal}Attributes(required = true, description = "The color of the item.")
	 * {@literal}Expose public String color = "";
	 * 
	 * The order in which attributes appear on the form is determined as follows:
	 * 
	 * this.class.getFields() presents the properties back using the following principles:
	 * 		Fields are presented in the order in which they are declared
	 * 		Fields are presented from the class, then each successive supertype up the hierarchy
	 * 		Fields that have {@literal}Attributes(id="top".... will appear first.
	 *     Fields that have {@literal}Attributes(id="bottom".... will appear last
	 *     Fields that lack an id attribute will appear in the middle.
	 *     
	 * @return the JsonObject representation of this JsonUiSchema object
	 */
	public JsonObject toJsonUiSchemaObject() {
		JsonObject json = new JsonObject();
		List<String> topFieldNames = new ArrayList<String>();
		List<String> middleFieldNames = new ArrayList<String>();
		List<String> bottomFieldNames = new ArrayList<String>();
		if (this.getClass().isAnnotationPresent(com.github.reinert.jjschema.Attributes.class)) {
			Attributes attributes = this.getClass().getAnnotation(com.github.reinert.jjschema.Attributes.class);
			if (attributes.readonly()) {
				json.addProperty("ui:readonly", true);
			}
		}
		for (Field field : this.getClass().getFields()) {
			// if you expect a field to show up, and it is not here, it could be because:
			// you did not make it public.  Or, you did not annotate it with the @Attribute annotation
				if (field.isAnnotationPresent(com.google.gson.annotations.Expose.class)) {
					if (field.isAnnotationPresent(com.github.reinert.jjschema.Attributes.class)) {
						Attributes attributes = field.getAnnotation(Attributes.class);
						if (attributes.readonly()) {
							JsonObject widget = new JsonObject();
							widget.addProperty("ui:readonly", true);
							json.add(field.getName(), widget);
						}
						if (attributes.id() == null) {
							middleFieldNames.add(field.getName());
						} else {
							if (attributes.id().equals("top")) {
								topFieldNames.add(field.getName());
							} else {
								bottomFieldNames.add(field.getName());
							}

						}
					} else {
						middleFieldNames.add(field.getName());
					}
					if (field.isAnnotationPresent(UiWidget.class)) {
						UiWidget uiWidget = field.getAnnotation(UiWidget.class);
						if (! uiWidget.value().startsWith(Constants.UI_WIDGET_DOMAINS )&& 
								! uiWidget.value().startsWith(Constants.UI_WIDGET_USERS)) {
							JsonObject widget = new JsonObject();
							widget.addProperty("ui:widget", uiWidget.value());
							json.add(field.getName(), widget);
						}
					}
				}
		}
		JsonArray fieldNames = new JsonArray();
		for (String name : topFieldNames) {
			fieldNames.add(name);
		}
		for (String name : middleFieldNames) {
			fieldNames.add(name);
		}
		for (String name : bottomFieldNames) {
			fieldNames.add(name);
		}
		json.add("ui:order", fieldNames);
		return json;
	}

	public double schemaIdAsNumber() {
		return serialVersionUID;
	}
	
	public String schemaIdAsString() {
		return this.getClass().getSimpleName() + ":" + String.valueOf(serialVersionUID);
	}

    /**
     * Set the json string to be prettyprinted
     * @param printPretty do you want this to print pretty?
     */
	public void setPrettyPrint(boolean printPretty) {
	    	if (printPretty) {
	        	gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
	    	} else {
	        	gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();        		
	    	}
	}
	public WsPaths resolveEndpointPaths() {
		WsPaths result = new WsPaths();
		try {
			result = NEW_FORM_CLASSES_DB_API.getEndpointPathsForAbstractModel(this.getClass());
		} catch (Exception e) {
			ErrorUtils.report(logger, e);
		}
		return result;
	}
	

}

