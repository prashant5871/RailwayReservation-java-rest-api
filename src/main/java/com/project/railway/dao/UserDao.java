package com.project.railway.dao;

import com.project.railway.entities.User;

public interface UserDao {

	public User saveUser(User user);
	public User findUserByUserName(String username);
}
