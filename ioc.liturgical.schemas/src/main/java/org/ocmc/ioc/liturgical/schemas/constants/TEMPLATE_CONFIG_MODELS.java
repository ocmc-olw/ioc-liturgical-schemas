package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.forms.template.TemplateConfig;
import org.ocmc.ioc.liturgical.schemas.models.supers.GenerationNodeConfig;

/**
 * Enumeration of all the kinds of Generation Unit Configs.
 * That is, all the POJOs that subclass GenerationUnitConfig.
 * These are used client side for the user to set the configuration
 * and server side when generating a book or service.
 * 
 * @author mac002
 *
 */
public enum TEMPLATE_CONFIG_MODELS {
	TEMPLATE_CONFIG(new TemplateConfig())
	;
	public GenerationNodeConfig model;
	
	TEMPLATE_CONFIG_MODELS(GenerationNodeConfig model) {
		this.model = model;
	}
}
