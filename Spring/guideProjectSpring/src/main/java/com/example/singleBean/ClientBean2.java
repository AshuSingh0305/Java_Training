package com.example.singleBean;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean2 {
	@Autowired
	private ServiceBean serviceBean;

	public void doSomething() {
		System.out.println("from ClientBean2: serviceBean: " + System.identityHashCode(serviceBean));
	}
}
/*
 * Similar to ClientBean1, this is another Java class named ClientBean2. It also
 * uses Spring's @Autowired annotation to inject the ServiceBean into its
 * serviceBean field. The doSomething method prints the identity hash code of
 * the serviceBean.
 */