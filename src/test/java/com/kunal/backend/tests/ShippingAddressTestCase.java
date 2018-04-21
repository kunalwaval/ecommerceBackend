package com.kunal.backend.tests;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kunal.backend.dao.ShippingAddressDAO;
import com.kunal.backend.model.*;

public class ShippingAddressTestCase {

	static ShippingAddressDAO shippingaddressDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.kunal");
		context.refresh();
		shippingaddressDAO = (ShippingAddressDAO) context.getBean("shippingaddressDAOImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveShippingAddressTest() {
		ShippingAddress shippingaddress = new ShippingAddress();
		shippingaddress.setShippingAddress("Mahogany Dining Table");
		shippingaddress.setUserName("Furniture");
		shippingaddressDAO.saveShippingAddress(shippingaddress);
		System.out.println("ShippingAddress Inserted");
	}

	// Retrieval TestCase
	@Ignore
	@Test
	public void getShippingAddressByIdTest() {
		ShippingAddress shippingaddress = shippingaddressDAO.getById(2);
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteShippingAddressTest() {
		ShippingAddress shippingaddress = shippingaddressDAO.getById(2);
		shippingaddressDAO.delete(2);
	}

	// Retrieving the Data
	@Ignore
	@Test
	public void getAllShippingAddresssTest() {
		List<ShippingAddress> list = shippingaddressDAO.list("Kunal");
		for (ShippingAddress shippingaddress : list) {
			System.out.println(shippingaddress.getShippingAddressId() + ":::");
		}
		System.out.println("ShippingAddress Displayed");
	}

}