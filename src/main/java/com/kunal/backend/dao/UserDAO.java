package com.kunal.backend.dao;

import java.util.List;

import com.kunal.backend.model.User;

public interface UserDAO {

	public void saveUser(User user);

	public List<User> getUserByEmail(String email, String password);
}
