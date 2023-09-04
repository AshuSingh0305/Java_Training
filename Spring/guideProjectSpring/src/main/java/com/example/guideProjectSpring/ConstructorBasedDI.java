package com.example.guideProjectSpring;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConstructorBasedDI {
	@Bean
	public OrderService orderService() {
		return new OrderService();
	}

	@Bean
	public OrderServiceClient orderServiceClient() {
		return new OrderServiceClient(orderService());
	}

	private static class OrderServiceClient {
		private OrderService orderService;

		OrderServiceClient(OrderService orderService) {
			this.orderService = orderService;
		}

		public void showPendingOrderDetails() {
			System.out.println(orderService.getOrderDetails("200"));
		}
	}

	public static void main(String... strings) {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConstructorBasedDI.class)) {
			OrderServiceClient bean = context.getBean(OrderServiceClient.class);
			bean.showPendingOrderDetails();
		} catch (BeansException e) {
			e.printStackTrace();
		}
	}
}
