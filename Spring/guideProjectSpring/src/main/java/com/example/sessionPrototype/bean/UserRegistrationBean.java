package com.example.sessionPrototype.bean;

import com.example.sessionPrototype.service.UserInfo;
import java.util.Map;

public interface UserRegistrationBean {
	public static String KEY_EMAIL = "email";
	public static String KEY_PASSWORD = "password";
	/*
	 * These lines declare two constant strings KEY_EMAIL and KEY_PASSWORD. These
	 * constants are meant to be used as keys when interacting with the bean to set
	 * or retrieve specific fields in user registration data.
	 */

	void setUserInfo(UserInfo userInfo);
	/*
	 * This line declares a method within the interface. The method is named
	 * setUserInfo, and it takes a single parameter of type UserInfo. This method is
	 * intended to set the user information that needs to be registered.
	 */

	Map<String, String> validate();
	/*
	 * This line declares another method named validate. This method doesn't take
	 * any parameters but is expected to return a Map containing validation errors
	 * (if any) after validating the user information.
	 */

	void register();
	/*
	 * This line declares a third method named register. This method doesn't take
	 * any parameters and is meant to initiate the registration process with the
	 * provided user information.
	 */
}
