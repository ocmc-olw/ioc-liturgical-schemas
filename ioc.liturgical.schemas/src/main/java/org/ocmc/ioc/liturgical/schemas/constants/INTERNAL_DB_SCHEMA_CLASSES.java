package org.ocmc.ioc.liturgical.schemas.constants;

import org.ocmc.ioc.liturgical.schemas.models.ws.db.Domain;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.Label;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.User;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.UserAuth;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.UserContact;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.UserHash;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.UserPreferences;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.UserStatistics;
import org.ocmc.ioc.liturgical.schemas.models.ws.db.Utility;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.AuthorizationCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.DomainCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.LabelCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.UserCreateForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.UserPasswordChangeForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.forms.UserPasswordSelfChangeForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.response.LiturgicalDayPropertiesForm;
import org.ocmc.ioc.liturgical.schemas.models.ws.response.Login;
import org.ocmc.ioc.liturgical.schemas.models.db.returns.LTKVString;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

/**
 * Enumerates classes that have schemas for storing in the database
 * @author mac002
 *
 */
public enum INTERNAL_DB_SCHEMA_CLASSES {
	ADMIN_NEW(new AuthorizationCreateForm())
	, DOMAIN_NEW(new DomainCreateForm())
	, DOMAIN(new Domain())
	, LABEL(new Label())
	, LABEL_NEW(new LabelCreateForm())
	, LITURGICAL_DAY_PROPERTIES_FORM(new LiturgicalDayPropertiesForm())
	, LOGIN(new Login())
	, LTKVSTRING(new LTKVString())
	, USER(new User())
	, USER_AUTH(new UserAuth())
	, USER_CONTACT(new UserContact())
	, USER_PREFERENCES(new UserPreferences())
	, USER_HASH(new UserHash())
	, USER_PASSWORD_CHANGE(new UserPasswordChangeForm())
	, USER_PASSWORD_SELF_CHANGE(new UserPasswordSelfChangeForm())
	, USER_NEW(new UserCreateForm())
	, USER_STATISTICS(new UserStatistics())
	, UTILITY(new Utility())
	;

	public AbstractModel obj;
	
	private INTERNAL_DB_SCHEMA_CLASSES(
			 AbstractModel obj
			) {
		this.obj = obj;
	}

	public static AbstractModel modelForSchemaName(String name) {
		for (INTERNAL_DB_SCHEMA_CLASSES s : INTERNAL_DB_SCHEMA_CLASSES.values()) {
			if (s.obj.schemaIdAsString().equals(name)) {
				return s.obj;
			}
		}
		return null;
	}
	
	public static INTERNAL_DB_SCHEMA_CLASSES classForSchemaName(String name) {
		for (INTERNAL_DB_SCHEMA_CLASSES s : INTERNAL_DB_SCHEMA_CLASSES.values()) {
			if (s.obj.schemaIdAsString().equals(name)) {
				return s;
			}
		}
		return null;
	}

}
