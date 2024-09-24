package com.project.railway.entities;

public class AuthorityId {
	public String user;
	public String authority;

	public AuthorityId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AuthorityId(String user, String authority) {
		super();
		this.user = user;
		this.authority = authority;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String toString() {
		return "AuthorityId [user=" + user + ", authority=" + authority + "]";
	}

}
