package com.example.guideProjectSpring;

/*In summary, this code sets up a Spring application 
 * that uses dependency injection to manage and connect the OrderService and OrderServiceClient
 *  classes. When you run the program, it demonstrates how Spring automatically 
 *  injects dependencies, making it easier to manage and maintain the application.
 */
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan({ "com.example.guideProjectSpring" })
/*
 * These lines mark the class ConstructorBasedDIWithScan as a configuration
 * class (@Configuration) and tell Spring to scan the package
 * com.example.dependencyInjection for components to manage (@ComponentScan).
 * This means Spring will look for classes annotated with @Component in that
 * package.
 */
public class ConstructorBasedDIWithScan {
	@Bean
	public OrderService orderService() {
		return new OrderService();
	}

	/*
	 * This is a method annotated with @Bean. It tells Spring to create and manage
	 * an instance of OrderService. When other parts of the application need an
	 * OrderService, Spring will provide this instance.
	 */

	@Component
	public static class OrderServiceClient {
		/*
		 * This line defines an inner class called OrderServiceClient and marks it as a
		 * Spring component using @Component. This means that Spring will manage
		 * instances of this class.
		 */
		private OrderService orderService;

		@Autowired
		OrderServiceClient(OrderService orderService) {
			this.orderService = orderService;
		}
		/*
		 * This is a constructor for OrderServiceClient. It's annotated with @Autowired,
		 * indicating that when an OrderServiceClient is created, Spring should provide
		 * an instance of OrderService as a parameter to this constructor. This is how
		 * dependency injection is achieved - the OrderService is "injected" into the
		 * OrderServiceClient.
		 */

		public void showPendingOrderDetails() {
			System.out.println(orderService.getOrderDetails("540"));
		}
		/*
		 * This method, showPendingOrderDetails, simply prints out some order details
		 * using the OrderService that was injected into the OrderServiceClient.
		 */
	}

	public static void main(String... strings) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ConstructorBasedDIWithScan.class)) {
			/*
			 * Here, an instance of AnnotationConfigApplicationContext is created, which is
			 * a Spring container for managing application components. It's configured with
			 * the ConstructorBasedDIWithScan class, so Spring will start managing the
			 * components defined in that class
			 */

			OrderServiceClient bean = context.getBean(OrderServiceClient.class);
			/*
			 * This line retrieves an instance of the OrderServiceClient from the Spring
			 * context. This instance will have its orderService field injected with the
			 * OrderService instance managed by Spring.
			 */

			bean.showPendingOrderDetails();
			/*
			 * this line calls the showPendingOrderDetails method on the OrderServiceClient
			 * instance, which in turn uses the injected OrderService to display some order
			 * details.
			 */

		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}