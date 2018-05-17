package com.kunal.Backend.dao;

import java.util.List;

import com.kunal.Backend.model.Category;
import com.kunal.Backend.model.Product;

public interface ProductDAO {
	public void saveProduct(Product product);

	List<Product> getAllProducts();

	Product getProductById(int id);

	void deleteProduct(Product product);
	void deleteProducts(int i);

	List<Category> getAllCategories();

	void saveCategory(Category category);

}
