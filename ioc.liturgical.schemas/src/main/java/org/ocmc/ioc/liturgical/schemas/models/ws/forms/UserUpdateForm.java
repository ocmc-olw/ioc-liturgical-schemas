package org.ocmc.ioc.liturgical.schemas.models.ws.forms;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.constants.FormFieldLengths;
import org.ocmc.ioc.liturgical.schemas.constants.FormRegExConstants;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

import com.github.reinert.jjschema.Attributes;

/**
 * This class provides a POJO for use in web forms to create or update a user
 * @author mac002
 *
 */
@Attributes(title = "User", description = "Schema for a User")
public class UserUpdateForm extends AbstractModel {
	@Attributes(readonly=true, required = true, description = "id used to login to system", minLength=FormFieldLengths.USERNAME_MIN)
	@Expose public String username = "";

	@Attributes(required = true, description = "first name of the user", minLength=FormFieldLengths.NAME_FIRST_MIN)
	@Expose public String firstname = "";

	@Attributes(required = true, description = "surname  of the user", minLength=FormFieldLengths.NAME_LAST_MIN)
	@Expose public String surname = "";

	@Attributes(required = true, description = "Title, e.g. 'Fr.', 'Dr.', or nothing")
	@Expose public String title = "";

	@Attributes(required = true, description = "email to contact the user", pattern=FormRegExConstants.EMAIL)
	@Expose public String email = "";

	@Attributes(required = true, description = "reenter email to contact the user", pattern=FormRegExConstants.EMAIL)
	@Expose public String emailReenter = "";

	@Attributes(required = false, description = FormRegExConstants.PASSWORD_DESCRIPTION, pattern=FormRegExConstants.PASSWORD_PATTERN)
	@Expose public String password = "";

	@Attributes(required = false, description = "reenter password", pattern=FormRegExConstants.PASSWORD_PATTERN)
	@Expose public String passwordReenter = "";

	@Attributes(
			required = true
			, readonly=true
			, description = "personal domain for the user"
			)
	@Expose public String domain = "";
	
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

}
