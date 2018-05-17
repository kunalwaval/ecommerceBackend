package com.kunal.Backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.Backend.model.Cart;
import com.kunal.Backend.model.CustomerOrder;
import com.kunal.Backend.model.Product;
import com.kunal.Backend.dao.OrderDAO;

@Repository
public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveOrder(CustomerOrder order) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(order);

	}

	public CustomerOrder list(String username) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CustomerOrder where user = ?");
		query.setString(0, username);
		return (CustomerOrder) query.uniqueResult();

	}

	public void removeAllOrderItem(String username) {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from CustomerOrder where user=?");
		query.setString(0, username);
		CustomerOrder order = (CustomerOrder) query.uniqueResult();
		session.delete(order);

	}

}
