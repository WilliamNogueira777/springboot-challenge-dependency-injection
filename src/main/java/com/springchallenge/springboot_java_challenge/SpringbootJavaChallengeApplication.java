package com.springchallenge.springboot_java_challenge;

import com.springchallenge.springboot_java_challenge.entities.Order;
import com.springchallenge.springboot_java_challenge.services.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@SpringBootApplication
public class SpringbootJavaChallengeApplication implements CommandLineRunner {

	private final OrderService orderService;

	public SpringbootJavaChallengeApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJavaChallengeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);

		List<Order> list = new ArrayList<>();

		Order order1 = new Order(1034, 150.00, 20.0);
		Order order2 = new Order(2282, 800.00, 10.0);
		Order order3 = new Order(1309, 95.90, 0.0);
		list.add(order1);
		list.add(order2);
		list.add(order3);

		for (Order orders : list) {
			System.out.println("SAÍDA");
			System.out.println("Pedido código: " + orders.getCode());
			System.out.printf("Valor total: %.2f%n", orderService.total(orders));
			System.out.println();
		}

	}
}
