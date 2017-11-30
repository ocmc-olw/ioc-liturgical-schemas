package org.ocmc.ioc.liturgical.schemas.models.ws.db;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

public class ValueSchema extends AbstractModel {

	@Expose public JsonObject schema;
	@Expose public JsonObject uiSchema;
	@Expose public WsPaths paths = null;
	
	public ValueSchema(AbstractModel obj) {
		super();
		this.schema = obj.toJsonSchemaObject();
		this.uiSchema = obj.toJsonUiSchemaObject();
		this.paths = obj.resolveEndpointPaths();
	}

	public JsonObject getSchema() {
		return schema;
	}

	public void setSchema(JsonObject schema) {
		this.schema = schema;
	}

	public JsonObject getUiSchema() {
		return uiSchema;
	}

	public void setUiSchema(JsonObject uiSchema) {
		this.uiSchema = uiSchema;
	}

	public WsPaths getPaths() {
		return paths;
	}

	public void setPaths(WsPaths paths) {
		this.paths = paths;
	}

}
