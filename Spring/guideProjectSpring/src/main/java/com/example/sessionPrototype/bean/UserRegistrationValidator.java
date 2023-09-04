package com.example.sessionPrototype.bean;

import java.util.regex.Pattern;

public class UserRegistrationValidator {
	private static final Pattern VALID_EMAIL_PATTERN = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);
	/*
	 * This line declares a private Pattern instance called VALID_EMAIL_PATTERN as a
	 * constant. It's initialized with a regular expression pattern for validating
	 * email addresses. This pattern checks for valid email formats.
	 */

	private static final Pattern VALID_PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9]{6,}$");
	/*
	 * This line declares another private Pattern instance called
	 * VALID_PASSWORD_PATTERN as a constant. It's initialized with a regular
	 * expression pattern for validating passwords. This pattern checks that
	 * passwords consist of at least 6 alphanumeric characters.
	 */

	public String validateEmail(String email) {
		if (!VALID_EMAIL_PATTERN.matcher(email).matches()) {
			return "Not a valid email: " + email;
		}
		return null;
	}

	public String validatePassword(String password) {
		if (!VALID_PASSWORD_PATTERN.matcher(password).matches()) {
			return "Not a valid password. The password should be alphanumeric and " + "at least 6 characters long ";
		}
		/*
		 * Inside the validateEmail method, it checks if the provided email matches the
		 * VALID_EMAIL_PATTERN. If the email doesn't match the pattern, it returns an
		 * error message indicating that the email is not valid.
		 */

		return null;
		/*
		 * If the email is valid, it returns null, indicating that there are no
		 * validation errors.
		 */
		
	}
}