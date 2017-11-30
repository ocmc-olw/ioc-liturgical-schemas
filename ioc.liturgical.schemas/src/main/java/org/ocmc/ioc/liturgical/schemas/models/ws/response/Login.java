package org.ocmc.ioc.liturgical.schemas.models.ws.response;

import com.google.gson.annotations.Expose;

import org.ocmc.ioc.liturgical.schemas.annotations.UiWidget;
import org.ocmc.ioc.liturgical.schemas.constants.Constants;
import org.ocmc.ioc.liturgical.schemas.models.supers.AbstractModel;

public class Login extends AbstractModel {
	@Expose public String username = "";
	
	@org.ocmc.ioc.liturgical.schemas.annotations.UiWidget(Constants.UI_WIDGET_PASSWORD)
	@Expose public String password = "";

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static void main(String[] args) {
		AbstractResponse<Login> result = new AbstractResponse<Login>(new Login(), true);
		System.out.println(result.toJsonString());
		
	}

}
