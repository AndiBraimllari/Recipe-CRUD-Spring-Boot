package com.project.service;

import com.project.model.User;

public interface UserServiceAbst {
	public User getUser(String title);
	public void updateUser(String name, String dish, String address, String password);
}
