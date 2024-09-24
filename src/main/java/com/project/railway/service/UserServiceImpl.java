package com.project.railway.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.railway.dao.UserDao;
import com.project.railway.entities.User;
import com.project.railway.security.CustomUserDetails;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {
//	@Autowired
	public UserDao userDao;
	// We should not use field base auto wiring because it is not good when we are doing Unit testing. so alway prefer to use constructor base autowiring.
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	public UserServiceImpl() {
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
}
