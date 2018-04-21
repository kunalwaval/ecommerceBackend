package com.kunal.backend.dao;

import java.util.List;

import com.kunal.backend.model.Category;
import com.kunal.backend.model.Product;

public interface ProductDAO {

	public void saveProduct(Product product);

	void saveCategory(Category category);

	Product getProductById(int id);

	List<Product> getAllProducts();

	void deleteProductById(int id);

	List<Category> getAllCategories();

}
