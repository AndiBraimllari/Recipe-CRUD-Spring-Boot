package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.UserDAOAbst;
import com.project.model.User;

@Service
public class UserService implements UserServiceAbst{
	@Autowired
	UserDAOAbst userdao;
	@Override
	public User getUser(String title){
		return userdao.getUser(title);
	}
	@Override
	public void updateUser(String name, String dish, String address, String password){
		userdao.updateUser(name, dish, address, password);
	}
}
