package com.example.guideProjectSpring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
 * This line tells Spring that the FieldBasedDI class is a configuration class.
 * In simple terms, it means this class will help set up and configure our
 * application
 */

public class FieldBasedDI {
	@Bean
	public OrderService orderService() {
		return new OrderService();
	}
	/*
	 * This method is marked with @Bean. It tells Spring to create and manage an
	 * instance of the OrderService class. Whenever someone needs an OrderService,
	 * Spring will provide this instance.
	 */

	@Bean
	public OrderServiceClient orderServiceClient() {
		return new OrderServiceClient();
	}
	/*
	 * Similarly, this method marked with @Bean tells Spring to create and manage an
	 * instance of the OrderServiceClient class.
	 */

	public static void main(String... strings) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FieldBasedDI.class)) {
			/*
			 * This is where Spring takes over. It creates a special context
			 * (AnnotationConfigApplicationContext) and configures it with the FieldBasedDI
			 * class. This context is like a container where Spring manages and wires up the
			 * objects.
			 */

			OrderServiceClient bean = context.getBean(OrderServiceClient.class);
			/*
			 * Now, we retrieve an instance of OrderServiceClient from the Spring context.
			 * This instance has its orderService field automatically set by Spring.
			 */

			bean.showPendingOrderDetails();
			/*
			 * Finally, we call the showPendingOrderDetails method on the OrderServiceClient
			 * instance, which in turn uses the injected OrderService to display some order
			 * details.
			 */

		} catch (BeansException e) {
			e.printStackTrace();
		}
	}

	private static class OrderServiceClient {
		/*
		 * Here, we define a private inner class named OrderServiceClient. It's only
		 * accessible within the FieldBasedDI class.
		 */

		@Autowired
		private OrderService orderService;
		/*
		 * In this line, we use the @Autowired annotation to tell Spring to
		 * automatically set the orderService field when creating an instance of
		 * OrderServiceClient. This is a way of injecting the required OrderService into
		 * OrderServiceClient.
		 */

		public void showPendingOrderDetails() {
			System.out.println(orderService.getOrderDetails("300"));
			/*
			 * This method, showPendingOrderDetails, simply prints out some order details
			 * using the orderService that was injected into the OrderServiceClient.
			 */
		}
	}
}
