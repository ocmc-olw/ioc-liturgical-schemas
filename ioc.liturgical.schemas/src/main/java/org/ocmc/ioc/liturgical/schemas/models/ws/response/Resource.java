package org.ocmc.ioc.liturgical.schemas.models.ws.response;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

/**
 * Model for return a Resource description to a REST requestor.
 * 
 * @author mac002
 *
 */
public class Resource extends AbstractModel {
	@Expose public String name;
	@Expose public String description;
}
