package org.ocmc.ioc.liturgical.schemas.models.formatting;

import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_FORMATS;
import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_SIZES;
import org.ocmc.ioc.liturgical.schemas.constants.META_TEXT_USAGES;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.google.gson.annotations.Expose;

/**
 * Abstract representation of an argument to a Liturgical Latex command
 * @author mac002
 *
 */
public class MetaCommandArg extends AbstractModel {
	@Expose public META_TEXT_USAGES usage = META_TEXT_USAGES.OPTIONAL;
    @Expose public META_TEXT_FORMATS format = META_TEXT_FORMATS.TEXT_BLACK;
    @Expose public META_TEXT_SIZES size = META_TEXT_SIZES.EM10;
    @Expose public String impliedTopic = "";
    @Expose public String impliedKey = "";
  
    public MetaCommandArg() {
    	super();
    }

	public String getImpliedTopic() {
		return impliedTopic;
	}

	public void setImpliedTopic(String impliedTopic) {
		this.impliedTopic = impliedTopic;
	}

	public String getImpliedKey() {
		return impliedKey;
	}

	public void setImpliedKey(String impliedKey) {
		this.impliedKey = impliedKey;
	}

	public META_TEXT_USAGES getUsage() {
		return usage;
	}

	public void setUsage(META_TEXT_USAGES usage) {
		this.usage = usage;
	}

	public META_TEXT_FORMATS getFormat() {
		return format;
	}


	public void setFormat(META_TEXT_FORMATS format) {
		this.format = format;
	}

	public META_TEXT_SIZES getSize() {
		return size;
	}

	public void setSize(META_TEXT_SIZES size) {
		this.size = size;
	}

}
