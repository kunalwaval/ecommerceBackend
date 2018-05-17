package com.kunal.Backend;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kunal.Backend.dao.SupplierDAO;
import com.kunal.Backend.model.Supplier;

public class SupplierTestCase {

	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.kunal");
		context.refresh();
		supplierDAO = (SupplierDAO) context.getBean("supplierImpl");
	
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveSupplierTest() {
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Supplier Dude");
		supplier.setSupplierContact(72329385);
		supplierDAO.saveSupplier(supplier);
		System.out.println("Added new Supplier");
	}

}