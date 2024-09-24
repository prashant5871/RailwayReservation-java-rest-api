package com.project.railway.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authority {
	@Id
	@ManyToOne
	@JoinColumn(name = "username", referencedColumnName = "username")
	private User user;
	@Id
	private String authority;
	
	

	public Authority(User user, String authority) {
		super();
		this.user = user;
		this.authority = authority;
	}
	

	public User getUser() {
		return user;
	}     

	public void setUser(User user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}
