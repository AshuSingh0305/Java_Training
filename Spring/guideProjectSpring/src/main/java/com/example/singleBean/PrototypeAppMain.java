package com.example.singleBean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

public class PrototypeAppMain {
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	@Bean
	public ServiceBean serviceBean() {
		return new ServiceBean();
	}
	/*
	 * Here, a method named serviceBean is defined. It is annotated with @Bean,
	 * which tells Spring to create and manage a bean of type ServiceBean.
	 * The @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) annotation specifies that
	 * this bean should be of prototype scope. In Spring, a prototype bean means
	 * that a new instance is created every time it is requested.
	 */

	@Bean
	public ClientBean1 clientBean1() {
		return new ClientBean1();
	}

	@Bean
	public ClientBean2 clientBean2() {
		return new ClientBean2();
	}

	public static void main(String[] args) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				PrototypeAppMain.class)) {
			context.getBean(ClientBean1.class).doSomething();
			context.getBean(ClientBean2.class).doSomething();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
/*
 * In summary, this code sets up a Spring application with three beans:
 * serviceBean, clientBean1, and clientBean2. The serviceBean is configured as a
 * prototype, meaning that a new instance is created every time it is requested.
 */