package org.ocmc.ioc.liturgical.schemas.models.ws.db;


import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;
import org.ocmc.ioc.liturgical.utils.ErrorUtils;
import org.ocmc.ioc.liturgical.utils.PasswordHasher;

public class UserHash extends AbstractModel {
	private static final Logger logger = LoggerFactory.getLogger(UserHash.class);
	
	@Expose public String hashedPassword = "";
	@Expose public boolean resetPwdNextLogin = true;
	
	public UserHash() {
		super();
		this.serialVersionUID = 1.1;
	}
		
	public String getHashedPassword() {
		return hashedPassword;
	}
	
	/**
	 * Use this method if you are starting from a hashed password.
	 * This is not the typical case.  Normally you will be starting with
	 * a plain text password.  if so, call setPassword instead.
	 * @param hashedPassword the hashed version of the password
	 */
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}
	/**
	 * Use this method when the user provides a plain text password.
	 * It will be hashed and stored as a hash.  Subsequent
	 * authentication will use the hashed value.
	 * @param password plain text
	 */
	public void setPassword(String password) {
		try {
			setHashedPassword(PasswordHasher.createHash(password));
		} catch (NoSuchAlgorithmException e) {
			ErrorUtils.report(logger, e);
		} catch (InvalidKeySpecException e) {
			ErrorUtils.report(logger, e);
		}
	}

	public boolean isResetPwdNextLogin() {
		return resetPwdNextLogin;
	}

	public void setResetPwdNextLogin(boolean resetPwdNextLogin) {
		this.resetPwdNextLogin = resetPwdNextLogin;
	}

}
