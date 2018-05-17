package com.kunal.Backend.dao;

import java.util.List;

import com.kunal.Backend.model.User;

public interface UserDAO {
	public void saveUser(User user);
	public List<User> getUserByEmail(String email, String password);
}
