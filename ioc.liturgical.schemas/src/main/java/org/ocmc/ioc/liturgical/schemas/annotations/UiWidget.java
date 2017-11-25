package org.ocmc.ioc.liturgical.schemas.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

/**
 * Allows developer to specify the ui:widget to use for a 
 * particular property.  In most cases it is not necessary to
 * explicitly do this.  The use cases for this annotation include:
 * 
 * 1. password (so that the password is masked)
 * 2. textarea (so that the text can be wrapped)
 * 
 * You can set the value of the annotation by using Constants.UI_WIDGET.{x}
 * e.g., Constants.UI_WIDGETS.PASSWORD
 * See <a href="https://github.com/mozilla-services/react-jsonschema-form"></a>
 * @author mac002
 *
 */
@Retention(RUNTIME)
public @interface UiWidget {
	String value();
}
