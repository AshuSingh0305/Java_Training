/*the UserRegistrationBeanImpl class encapsulates the user registration process, 
 * handling data, validation, and registration actions. It conforms to the contract 
 * defined by the UserRegistrationBean interface, providing a standardized way to 
 * perform user registration while allowing for flexibility and extensibility through 
 * dependency injection.
 */
package com.example.sessionPrototype.bean;

import com.example.sessionPrototype.service.RegistrationService;
import com.example.sessionPrototype.service.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.LinkedHashMap;
import java.util.Map;

public class UserRegistrationBeanImpl implements UserRegistrationBean {
	@Autowired
	private RegistrationService registrationService;
	/*
	 * This line uses the @Autowired annotation to inject an instance of
	 * RegistrationService into the UserRegistrationBeanImpl class. This injection
	 * allows the UserRegistrationBeanImpl to use the registrationService to perform
	 * user registration.
	 */

	@Autowired
	private UserRegistrationValidator validator;
	/*
	 * this line uses @Autowired to inject an instance of UserRegistrationValidator
	 * into the class. The validator will be used for user information validation.
	 */

	private UserInfo userInfo;
	/*
	 * This line declares a private instance variable called userInfo. This variable
	 * will hold the user information that needs to be registered.
	 */

	@Override
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	/*
	 * This is the implementation of the setUserInfo method from the
	 * UserRegistrationBean interface. It sets the userInfo variable with the
	 * provided user information.
	 */

	@Override
	public Map<String, String> validate() {
		if (userInfo == null) {
			throw new RuntimeException("UserInfo must be set before calling validate method");
		}
		Map<String, String> errors = new LinkedHashMap<>();
		String errorMessage = validator.validateEmail(userInfo.getEmail());
		if (errorMessage != null) {
			errors.put(KEY_EMAIL, errorMessage);
		}
		errorMessage = validator.validatePassword(userInfo.getPassword());
		if (errorMessage != null) {
			errors.put(KEY_PASSWORD, errorMessage);
		}
		return errors;
	}
	/*
	 * This is the implementation of the validate method from the
	 * UserRegistrationBean interface. It validates the user information, checking
	 * if the userInfo variable is set and then using the UserRegistrationValidator
	 * to validate the email and password. Any validation errors are collected in a
	 * Map and returned.
	 */

	@Override
	public void register() {
		registrationService.register(userInfo);
	}
	/*
	 * This is the implementation of the register method from the
	 * UserRegistrationBean interface. It uses the injected registrationService to
	 * initiate the registration process with the provided user information
	 * (userInfo).
	 */
}
