package org.ocmc.ioc.liturgical.schemas.models.ws.forms;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.constants.FormFieldLengths;
import org.ocmc.ioc.liturgical.schemas.constants.FormRegExConstants;
import org.ocmc.ioc.liturgical.schemas.models.exceptions.SchemaException;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.github.reinert.jjschema.Attributes;

/**
 * This class provides a POJO for use in web forms to create or update a user
 * @author mac002
 *
 */
@Attributes(title = "User", description = "Schema for a User")
public class UserCreateForm extends AbstractModel {
	@Attributes(required = true, description = "id used to login to system", minLength=FormFieldLengths.USERNAME_MIN)
	@Expose public String username = "";

	@Attributes(required = true, description = "first name of the user", minLength=FormFieldLengths.NAME_FIRST_MIN)
	@Expose public String firstname = "";
	
	@Attributes(required = true, description = "last name (i.e., family name, or surname)  of the user", minLength=FormFieldLengths.NAME_LAST_MIN)
	@Expose public String lastname = "";

	@Attributes(required = true, description = "Title, e.g. 'Fr.', 'Dr.', or nothing")
	@Expose public String title = "";

	@Attributes(required = true, description = "email to contact the user", pattern=FormRegExConstants.EMAIL)
	@Expose public String email = "";
	
	@Attributes(required = true, description = "reenter email to contact the user", pattern=FormRegExConstants.EMAIL)
	@Expose public String emailReenter = "";
	
	@UiWidget(Constants.UI_WIDGET_PASSWORD)
	@Attributes(required = true, description = FormRegExConstants.PASSWORD_DESCRIPTION, pattern=FormRegExConstants.PASSWORD_PATTERN)
	@Expose public String password = "";
	
	@UiWidget(Constants.UI_WIDGET_PASSWORD)
	@Attributes(required = true, description = "reenter password", pattern=FormRegExConstants.PASSWORD_PATTERN)
	@Expose public String passwordReenter = "";
		
	@Attributes(
			required = true
			, description = "code for the language the user will primarily use when creating docs"
			, minLength=FormFieldLengths.LANGUAGE_CODE_MIN
			, maxLength=FormFieldLengths.LANGUAGE_CODE_MAX
			)
	@Expose public String languageCode = "en";
	
	@Attributes(
			required = true
			, description = "code for country in which this dialect of the language is spoken"
			, minLength=FormFieldLengths.COUNTRY_CODE_MIN
			, maxLength=FormFieldLengths.COUNTRY_CODE_MAX
			)
	@Expose public String countryCode = "us";
	
	public UserCreateForm() {
		super();
		this.serialVersionUID = 1.1;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailReenter() {
		return emailReenter;
	}

	public void setEmailReenter(String emailReenter) {
		this.emailReenter = emailReenter;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordReenter() {
		return passwordReenter;
	}

	public void setPasswordReenter(String passwordReenter) {
		this.passwordReenter = passwordReenter;
	}

	public boolean valid(String json) {
		return this.validate(json).length() == 0;
	}
	
	public String validate(String json) {
		if (this.passwordsMatch()) {
			if (this.emailsMatch()) {
				return super.validate(json);
			} else {
				return new SchemaException("#/email","matches","Expected email to match emailReenter but does not.").toJsonString();
			}
		} else {
			return new SchemaException("#/password","matches","Expected password to match passwordReenter but does not.").toJsonString();
		}
	}
	
	private boolean passwordsMatch() {
		return (this.password.length() == this.passwordReenter.length() && this.password.startsWith(this.passwordReenter));
	}
	
	private boolean emailsMatch() {
		return (this.email.length() == this.emailReenter.length() && this.email.startsWith(this.emailReenter));
	}
	public String getLanguageCode() {
		return languageCode;
	}
	public void setLanguageCode(String languageCode) {
		this.languageCode = languageCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
