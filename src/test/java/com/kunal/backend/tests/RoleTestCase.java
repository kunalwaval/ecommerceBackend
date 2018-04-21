package com.kunal.backend.tests;

import java.util.List;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kunal.backend.dao.RoleDAO;
import com.kunal.backend.model.*;

public class RoleTestCase {

	static RoleDAO roleDAO;

	@BeforeClass
	public static void executeFirst() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.kunal");
		context.refresh();
		roleDAO = (RoleDAO) context.getBean("roleDAOImpl");
	}

	// Adding TestCase
	@Ignore
	@Test
	public void saveRoleTest() {
		Role role = new Role();
		role.setRole("Mahogany Dining Table");
		roleDAO.saveOrUpdate(role);
		System.out.println("Customer");
	}

	// Retrieval TestCase
	@Ignore
	@Test
	public void getRoleByIdTest() {
		Role role = roleDAO.getByUserName("Kunal");
		System.out.println("Role Name:" + roleDAO.getByUserName("Kunal"));
	}

	// Deletion TestCase
	@Ignore
	@Test
	public void deleteRoleTest() {
		Role role = roleDAO.getByUserName("Kunal");
		roleDAO.delete("Kunal");
		System.out.println("The Role Deleted");
	}

	// Retrieving the Data
	@Ignore
	@Test
	public void getAllRolesTest() {
		List<Role> list = roleDAO.list();
		for (Role role : list) {
			System.out.println(role.getRoleId() + ":::");
		}
		System.out.println("Role Displayed");
	}

}