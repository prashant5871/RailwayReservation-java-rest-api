package com.project.railway.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import com.project.railway.entities.User;

public class CustomUserDetails implements UserDetails {

	public User user;

	public CustomUserDetails(User user) {
		this.user = user;
	}

	public CustomUserDetails() {
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
//		if (user != null && user.getRole() != null) {
			// Assuming user.getRole() returns a single role as String
//			authorities.add(new SimpleGrantedAuthority(user.getRole()));
			// If user has multiple roles stored as a list or set of strings
			// user.getRoles().forEach(role -> authorities.add(new
			// SimpleGrantedAuthority(role)));
//		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
