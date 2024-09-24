package com.project.railway.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.project.railway.entities.User;

public interface UserService {
	public User saveUser(User user);
}
