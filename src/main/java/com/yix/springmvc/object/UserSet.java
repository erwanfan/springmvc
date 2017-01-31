package com.yix.springmvc.object;

import java.util.HashSet;
import java.util.Set;

public class UserSet {
	private Set<User> users;
	
	

	public UserSet() {
		this.users = new HashSet<User>();
		this.users.add(new User("1", null));
		this.users.add(new User("2", null));
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserSet [users=" + users + "]";
	}
}
