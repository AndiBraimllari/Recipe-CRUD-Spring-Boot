package com.project.dao;

import com.project.model.User;

public interface UserDAOAbst {
	public User getUser(String name);
	public void updateUser(String name, String dish, String address, String password);
}
