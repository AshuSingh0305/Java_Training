package com.example.sessionPrototype;

import com.example.sessionPrototype.bean.UserRegistrationBean;
import com.example.sessionPrototype.service.UserInfo;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

public class AppMain {
	private final PrintStream printStream;
	private Scanner scanner;

	public AppMain(InputStream inputStream, PrintStream printStream) {
		this.scanner = new Scanner(inputStream);
		this.printStream = printStream;
	}

	public static void main(String[] args) {
		AppMain appMain = new AppMain(System.in, System.out);
		appMain.start();
	}

	public void start() {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class)) {
			/*
			 * This is the start method, where the application begins its execution. It
			 * creates an instance of AnnotationConfigApplicationContext, which is a Spring
			 * container that manages beans and their lifecycles. It's configured with the
			 * Config class, which contains the bean definitions.
			 */

			UserRegistrationBean registrationBean = context.getBean(UserRegistrationBean.class);
			/*
			 * This line retrieves a bean of type UserRegistrationBean from the Spring
			 * application context. This bean is used for user registration.
			 */

			while (true) {
				printStream.println("UserRegistrationBean, instance: " + System.identityHashCode(registrationBean));
				printStream.println("Enter new user. Enter exit to terminate");
				boolean exit = registerUser(registrationBean);
				if (exit) {
					break;
				}
				registrationBean = context.getBean(UserRegistrationBean.class);
			}
			/*
			 * This is a loop that allows the user to perform user registrations repeatedly
			 * until they choose to exit. Within the loop, it prints a message containing
			 * the identity hash code of the registrationBean (useful for debugging). It
			 * then calls the registerUser method to handle user registration. If the user
			 * decides to exit, the loop breaks, otherwise, a new instance of
			 * UserRegistrationBean is retrieved from the context for the next registration.
			 */

		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	private boolean registerUser(UserRegistrationBean registrationBean) {
		UserInfo userInfo = new UserInfo();
		/*
		 * This is a private method named registerUser, which takes a
		 * UserRegistrationBean as a parameter. It starts by creating a new UserInfo
		 * object, which represents user information.
		 */

		registrationBean.setUserInfo(userInfo);
		/*
		 * It then sets this userInfo object in the registrationBean using the
		 * setUserInfo method. This step provides the user information to the
		 * registration bean.
		 */

		Map<String, String> errors = null;
		/*
		 * It initializes a variable called errors to null. This variable will be used
		 * to collect validation errors during user registration.
		 */

		while (errors == null || errors.size() > 0) {
			/*
			 * This initiates a loop that continues until there are no validation errors
			 * (errors.size() == 0). The loop also continues if errors is null, which could
			 * happen if validate method fails to set errors properly.
			 */

			if (errors != null) {
				printStream.println("Errors : " + errors.values() + "\n");
				printStream.println("Please enter exit to terminate");
			}
			if (errors == null || errors.containsKey(UserRegistrationBean.KEY_EMAIL)) {
				String email = getUserInput("Enter Email");
				if (email == null) {
					return true;
				}
				userInfo.setEmail(email);
			}
			/*
			 * This section handles the input of the user's email address. If there are
			 * errors related to the email or if errors is null, it prompts the user to
			 * enter their email. If the user enters "exit," the method returns true,
			 * indicating that the user wants to exit. Otherwise, it sets the email in the
			 * userInfo object.
			 */

			if (errors == null || errors.containsKey(UserRegistrationBean.KEY_PASSWORD)) {
				String password = getUserInput("Enter Password");
				if (password == null) {
					return true;
				}
				userInfo.setPassword(password);
			}
			/*
			 * this section handles the input of the user's password. If there are errors
			 * related to the password or if errors is null, it prompts the user to enter
			 * their password. If the user enters "exit," the method returns true.
			 * Otherwise, it sets the password in the userInfo object.
			 */

			errors = registrationBean.validate();
			/*
			 * After setting the user information, it calls the validate method of the
			 * registrationBean to perform validation. Any validation errors are collected
			 * in the errors variable. The loop continues until no errors are found,
			 * ensuring that the user provides valid information.
			 */
		}
		registrationBean.register();
		/*
		 * Once valid information is provided, it calls the register method of the
		 * registrationBean to perform user registration. This method initiates the
		 * registration process.
		 */

		printStream.println("User has been registered successfully: " + userInfo);
		return false;
		/*
		 * The registerUser method returns false, indicating that the registration
		 * process is not terminated, and the loop can continue for the next user
		 * registration.
		 */
	}

	public String getUserInput(String instruction) {
		printStream.print(instruction + ">");
		String s = scanner.nextLine();
		if ("exit".equals(s)) {
			return null;
		}
		return s;
	}
	/*
	 * This is a utility method named getUserInput that takes an instruction as a
	 * parameter and prompts the user to enter input with that instruction. It
	 * returns the user's input as a string. If the user enters "exit," it returns
	 * null, indicating that the user wants to exit the registration process.
	 */
}