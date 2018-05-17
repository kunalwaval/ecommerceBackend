package com.kunal.Backend;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kunal.Backend.dao.OrderDAO;
import com.kunal.Backend.model.CustomerOrder;

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
		CustomerOrder order = new CustomerOrder();
		order.setUser("Kunal");
		orderDAO.saveOrder(order);
		System.out.println("Order Inserted");
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteOrderTest() {
		CustomerOrder order = orderDAO.list("Kunal");
		orderDAO.removeAllOrderItem("Kunal");
		System.out.println("The Order Deleted");
	}

}