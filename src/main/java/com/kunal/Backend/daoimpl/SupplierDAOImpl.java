package com.kunal.Backend.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.Backend.model.Supplier;
import com.kunal.Backend.dao.SupplierDAO;

@Repository
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public SupplierDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveSupplier(Supplier supplier) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(supplier);
	}

}
