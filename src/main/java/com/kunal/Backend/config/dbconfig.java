package com.kunal.Backend.config;

import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kunal.Backend.daoimpl.*;
import com.kunal.Backend.dao.*;
import com.kunal.Backend.model.*;

@Configuration
@ComponentScan("com.kunal")
@EnableTransactionManagement
public class dbconfig {

	@Bean(name = "dataSource")
	public DataSource getH2DataSource() {
		System.out.println("Starting of the method getH2DataSource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecommerce");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		System.out.println("Data Source Creation");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
		System.out.println("---Hibernate Properties----");
		Properties prop = new Properties();
		prop.setProperty("hibernate.hbm2ddl.auto", "update");
		prop.put("hibernate.show_sql", "true"); // optional
		prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		System.out.println("---Hibernate Properties Created");

		System.out.println("---Local SessionFactory Builder Object Creation---");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(prop);
		System.out.println("Factory Builder Object Created");
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Cart.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Role.class);
		sessionBuilder.addAnnotatedClass(CustomerOrder.class);
		sessionBuilder.addAnnotatedClass(ShippingAddress.class);
		System.out.println("Session Factory Object Creation");
		SessionFactory sessionFactory = sessionBuilder.buildSessionFactory();
		System.out.println("Session Factory Object Created");
		return sessionFactory;
	}

	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		System.out.println("Transaction manager Object Creation");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction manager Object Created");
		return transactionManager;
	}

	@Autowired
	@Bean(name = "categoryDAOImpl")
	public CategoryDAOImpl getCategoryDAOImpl(SessionFactory sessionFactory) {
		System.out.println("CategoryImpl Object Creation");
		return new CategoryDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "orderDAOImpl")
	public OrderDAOImpl getOrderDAOImpl(SessionFactory sessionFactory) {
		System.out.println("OrderImpl Object Creation");
		return new OrderDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "productDAOImpl")
	public ProductDAOImpl getProductDAOImpl(SessionFactory sessionFactory) {
		System.out.println("ProductImpl Object Creation");
		return new ProductDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "roleDAOImpl")
	public RoleDAOImpl getRoleDAOImpl(SessionFactory sessionFactory) {
		System.out.println("RoleImpl Object Creation");
		return new RoleDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "supplierDAOImpl")
	public SupplierDAOImpl getSupplierDAOImpl(SessionFactory sessionFactory) {
		System.out.println("SupplierImpl Object Creation");
		return new SupplierDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "shippingaddressDAOImpl")
	public ShippingAddressDAOImpl getShippingAddressDAOImpl(SessionFactory sessionFactory) {
		System.out.println("ShippingAddressImpl Object Creation");
		return new ShippingAddressDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "cartDAOImpl")
	public CartDAOImpl getCartDAOImpl(SessionFactory sessionFactory) {
		System.out.println("CartImpl Object Creation");
		return new CartDAOImpl(sessionFactory);
	}

	@Autowired
	@Bean(name = "userDAOImpl")
	public UserDAOImpl getUserDAOImpl(SessionFactory sessionFactory) {
		System.out.println("UserImpl Object Creation");
		return new UserDAOImpl(sessionFactory);
	}
}