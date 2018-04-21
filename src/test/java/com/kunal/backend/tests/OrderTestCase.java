package com.kunal.backend.tests;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kunal.backend.dao.OrderDAO;
import com.kunal.backend.model.Order;

public class OrderTestCase {

	static OrderDAO orderDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.kunal");
		context.refresh();
		orderDAO = (OrderDAO) context.getBean("orderDAOImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveOrderTest() {
		Order order = new Order();
		order.setUser("Kunal");
		orderDAO.saveOrder(order);
		System.out.println("Order Inserted");
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteOrderTest() {
		Order order = orderDAO.list("Kunal");
		orderDAO.removeAllOrderItems("Kunal");
		System.out.println("The Order Deleted");
	}

}