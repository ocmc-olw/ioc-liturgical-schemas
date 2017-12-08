package org.ocmc.ioc.liturgical.schemas.models.forms.template;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractSchemaModel;
import org.ocmc.ioc.liturgical.schemas.models.supers.GenerationNodeConfig;

import com.github.reinert.jjschema.Attributes;

/**
 * @author mac002
 *
 */
@Attributes(title = "Template Configuration", description = "Configuration of a Template  (equivalent of an ALWB Template Head)")
public class TemplateConfig extends GenerationNodeConfig {
	
	private static String schema = TemplateConfig.class.getSimpleName();
	private static double version = 1.1; 
	
	@Attributes(id = "top", minimum = 1, maximum = 12, description = "Month number, starting with 1 for January")
	@Expose public int month = 1;

	@Attributes(id = "top", minimum = 1, maximum = 31, description = "The day of the month as a number, starting with 1.")
	@Expose public int day = 1;

	@Attributes(id = "top", minimum = 2000, maximum = 3000, description = "The year as a number")
	@Expose public int year = 1;

	public TemplateConfig() {
		super(schema, version);
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
