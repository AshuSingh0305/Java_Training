package com.example.sessionPrototype;

import com.example.sessionPrototype.bean.UserRegistrationBean;
import com.example.sessionPrototype.bean.UserRegistrationBeanImpl;
import com.example.sessionPrototype.bean.UserRegistrationValidator;
import com.example.sessionPrototype.service.RegistrationService;
import com.example.sessionPrototype.service.RegistrationServiceImpl;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
/*
 * This line is a class-level annotation that indicates that the Config class is
 * a configuration class for Spring. It tells Spring that this class contains
 * bean definitions and should be processed to configure the application
 * context.
 */

public class Config {
	@Bean
	public UserRegistrationValidator validator() {
		return new UserRegistrationValidator();
	}
	/*
	 * This method is annotated with @Bean, which tells Spring to create and manage
	 * a bean of type UserRegistrationValidator. The method defines how to create an
	 * instance of UserRegistrationValidator and returns it. This bean is used for
	 * user information validation.
	 */

	@Bean
	public RegistrationService registrationService() {
		return new RegistrationServiceImpl();
	}
	/*
	 * Similar to the previous method, this one is also annotated with @Bean. It
	 * defines a bean of type RegistrationService and returns an instance of
	 * RegistrationServiceImpl. This bean represents the registration service.
	 */

	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public UserRegistrationBean userRegistrationBean() {
		return new UserRegistrationBeanImpl();
	}
	/*
	 * This method is annotated with @Scope, specifying that the bean's scope should
	 * be prototype. Prototype scope means that a new instance of the bean is
	 * created each time it's requested. The method also has @Bean, indicating that
	 * it defines a bean of type UserRegistrationBean and returns an instance of
	 * UserRegistrationBeanImpl. This bean represents the user registration bean.
	 */
}
