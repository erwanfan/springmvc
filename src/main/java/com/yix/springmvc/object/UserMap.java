package com.yix.springmvc.object;

import java.util.HashMap;
import java.util.Map;

public class UserMap {
	private Map<String, User> users;

	public UserMap() {
		this.users = new HashMap<String, User>();
	}

	public Map<String, User> getUsers() {
		return users;
	}

	public void setUsers(Map<String, User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "UserMap [users=" + users + "]";
	}

}
