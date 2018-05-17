package com.kunal.Backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.Backend.model.Category;
import com.kunal.Backend.model.Product;
import com.kunal.Backend.dao.ProductDAO;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Autowired
	private SessionFactory sessionFactory;
	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		
}

	public void saveProduct(Product product) {
		System.out.println("SOP1");
		Session session = sessionFactory.openSession();
		System.out.println("SOP2");		
		session.saveOrUpdate(product);
		System.out.println("SOP3");
	}

	public List<Product> getAllProducts() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Product");
		List<Product> products = query.list();
		return products;
	}

	public Product getProductById(int id) {
		Session session = sessionFactory.openSession();
		Product product = (Product) session.get(Product.class, id);
		return product;
	}

	public void deleteProducts(int id) {
		Session session = sessionFactory.openSession();
		session.delete(id);

	}

	public void deleteProduct(Product product) {
		Session session = sessionFactory.openSession();
		session.delete(product);

	}

	public List<Category> getAllCategories() {
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Category");
		List<Category> categories = query.list();
		return categories;
	}

	public void saveCategory(Category category) {
		Session session = sessionFactory.openSession();
		session.save(category);
	}

}
