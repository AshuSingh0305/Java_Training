package com.example.sessionPrototype.service;

public interface RegistrationService {
	/*
	 * This line declares a public Java interface named RegistrationService. An
	 * interface defines a contract for classes that implement it. In this case, it
	 * defines the contract for a registration service.
	 */

	void register(UserInfo userInfo);
	/*
	 * This line declares a method within the interface. The method is named
	 * register, and it takes a single parameter of type UserInfo. This method is
	 * meant to be implemented by classes that implement the RegistrationService
	 * interface, and it is responsible for registering user information.
	 */
}