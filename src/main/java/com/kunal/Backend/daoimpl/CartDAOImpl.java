package com.kunal.Backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.Backend.model.Cart;
import com.kunal.Backend.model.Product;
import com.kunal.Backend.dao.CartDAO;

@Repository
public class CartDAOImpl implements CartDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public CartDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public void saveCart(Cart cart) {
		Session session = sessionFactory.openSession();
		session.saveOrUpdate(cart);
	}

	public List<Cart> getCartByUsername(String username) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		return query.list();
	}

	public void removeCartItem(int cartitemid) {
		Session session = sessionFactory.getCurrentSession();
		Cart cartitem = (Cart) session.get(Cart.class, cartitemid);
		Product product = cartitem.getProducts();
		product.setStock(product.getStock() + cartitem.getQuantity());
		session.delete(cartitem);

	}

	public void removeAllCartItem(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Cart where user=?");
		query.setString(0, username);
		List<Cart> cartitems = query.list();
		for (Cart cartitem : cartitems) {
			Product product = cartitem.getProducts();
			product.setStock(product.getStock() + cartitem.getQuantity());
			session.delete(cartitem);
		}
	}
}