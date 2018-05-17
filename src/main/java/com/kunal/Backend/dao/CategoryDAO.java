package com.kunal.Backend.dao;

import java.util.List;

import com.kunal.Backend.model.Category;

public interface CategoryDAO {
	public void saveCategory(Category category);

	public void deleteCategory(int categoryId);

	public Category getById(int categoryId);

	public List<Category> list();
}
