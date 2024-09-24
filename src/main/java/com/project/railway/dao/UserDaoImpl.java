package com.project.railway.dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.project.railway.entities.Authority;
import com.project.railway.entities.User;

import jakarta.persistence.EntityManager;

@Repository
public class UserDaoImpl implements UserDao {
	public EntityManager entityManager;
	
//	public BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserDaoImpl(EntityManager entityManager)
	{
		this.entityManager = entityManager;
//		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public User saveUser(User user) {
		Authority authority = new Authority(user, "ROLE_USER");
		entityManager.persist(authority);
		user.setPassword("{noop}"+user.getPassword());
		return entityManager.merge(user);
	}
	
	public User findUserByUserName(String username)
	{
		return entityManager.find(User.class, username);
	}

}
