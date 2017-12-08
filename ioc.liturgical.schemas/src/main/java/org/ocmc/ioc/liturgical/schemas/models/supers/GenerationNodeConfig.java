package org.ocmc.ioc.liturgical.schemas.models.supers;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractSchemaModel;

import com.github.reinert.jjschema.Attributes;
import com.google.gson.annotations.Expose;

/**
 * The superclass for all POJOs that store configuration information for
 * a node to be used in generating a book or service.
 * @author mac002
 *
 */
@Attributes(title = "Generation Node Configuration", description = "Configuration of a node used to generate a book or service")
public class GenerationNodeConfig extends AbstractSchemaModel {
	
	@Expose public boolean excludeFromNewFormDropdown = true; // so we can exclude it from the new forms dropdown, but include in uiSchemas
	
	public GenerationNodeConfig(
			String schema
			, double version
			) {
		super(schema, version);
	}

	public boolean isExcludeFromNewFormDropdown() {
		return excludeFromNewFormDropdown;
	}

	public void setExcludeFromNewFormDropdown(boolean excludeFromNewFormDropdown) {
		this.excludeFromNewFormDropdown = excludeFromNewFormDropdown;
	}

}
