package com.example.guideProjectSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Spring Demo");
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj.getName() + " " + obj.getMessage());
		
		System.out.println("Spring ApplicationContext Container");
		System.out.println("FileSystemXmlApplicationContext");
		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj1.getName()+ " "+ obj1.getMessage());
		System.out.println("ClassPathXmlApplicationContext");
		
		@SuppressWarnings({ "unused", "resource" })
		ApplicationContext context1 = new ClassPathXmlApplicationContext("Beans.xml");
		HelloWorld obj2 = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj2.getName()+ " "+ obj2.getMessage());

		
	}
}
