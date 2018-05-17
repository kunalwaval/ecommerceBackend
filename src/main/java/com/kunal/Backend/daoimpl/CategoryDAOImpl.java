package com.kunal.Backend.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kunal.Backend.model.Category;
import com.kunal.Backend.dao.CategoryDAO;
@Repository
public class CategoryDAOImpl implements CategoryDAO{
	@Autowired
	private SessionFactory sessionFactory;
	public CategoryDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void saveCategory(Category category) {
		/*System.out.println(category.getCategoryId());
		System.out.println(category.getCategoryName());
*/		Session session= sessionFactory.openSession();
		session.saveOrUpdate(category);
	}
	public void deleteCategory(int categoryId) {
		// TODO Auto-generated method stub
		Category categoryToDelete = new Category();
        categoryToDelete.setCategoryId(categoryId);
        sessionFactory.getCurrentSession().delete(categoryToDelete);

	}
	public Category getById(int categoryId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        String hql = "from Category where categoryId = '"+ categoryId+"'";
        Query query = session.createQuery(hql);
        List<Category> categories = query.list();
        if(categories != null && !categories.isEmpty()){
            return categories.get(0);
        }
       
        return null;
		
	}
	public List<Category> list() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Category");
        List<Category> categories = query.list();
        return categories;
		
	}
	
	

}
