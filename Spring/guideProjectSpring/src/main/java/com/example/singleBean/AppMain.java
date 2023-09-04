package com.example.singleBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class AppMain {
	@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
	@Bean
	public ServiceBean serviceBean() {
		return new ServiceBean();
	}
	/*
	 * Here, a method named serviceBean is defined. It is annotated with @Bean,
	 * which tells Spring to create and manage a bean of type ServiceBean.
	 * The @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON) annotation specifies that
	 * this bean should be a singleton, meaning there will be only one instance of
	 * it in the entire application.
	 */

	@Bean
	public ClientBean1 clientBean1() {
		return new ClientBean1();
	}
	/*
	 * This method, clientBean1, is annotated with @Bean as well. It tells Spring to
	 * create and manage a bean of type ClientBean1.
	 */

	@Bean
	public ClientBean2 clientBean2() {
		return new ClientBean2();
	}
	/*
	 * Similarly, this method, clientBean2, is annotated with @Bean to create and
	 * manage a bean of type ClientBean2.
	 */

	public static void main(String[] args) {
		runApp();
		runApp();
	}

	private static void runApp() {
		System.out.println("--- running app ---");
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppMain.class)) {
			/*
			 * Creates an instance of AnnotationConfigApplicationContext based on the
			 * AppMain class. This is the Spring application context where beans are
			 * managed.
			 */

			context.getBean(ClientBean1.class).doSomething();
			context.getBean(ClientBean2.class).doSomething();
			/*
			 * Retrieves an instance of ClientBean1 from the context using
			 * context.getBean(ClientBean1.class) and calls its doSomething method.
			 * Similarly, it retrieves an instance of ClientBean2 and calls its doSomething
			 * method.
			 */

		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}

/*
 * this code sets up a Spring application with three beans: serviceBean,
 * clientBean1, and clientBean2. The serviceBean is configured as a singleton,
 * and the runApp method demonstrates how to create a Spring application context
 * and access and use these beans within the context. Each run of the
 * application shows that both ClientBean1 and ClientBean2 share the same
 * instance of ServiceBean because it is a singleton.
 */