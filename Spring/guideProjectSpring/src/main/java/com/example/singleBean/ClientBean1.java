package com.example.singleBean;

import org.springframework.beans.factory.annotation.Autowired;

public class ClientBean1 {
	@Autowired
	private ServiceBean serviceBean;

	public void doSomething() {
		System.out.println("from ClientBean1: serviceBean: " + System.identityHashCode(serviceBean));
	}
}

/*
 * This is another Java class named ClientBean1. It's using Spring's @Autowired
 * annotation to inject the ServiceBean into its serviceBean field. The
 * doSomething method simply prints the identity hash code of the serviceBean.
 */
