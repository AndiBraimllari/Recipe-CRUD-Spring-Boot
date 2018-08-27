package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.model.User;

public class UserDAO implements UserDAOAbst{
	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	@SuppressWarnings("unchecked")
	public User getUser(String name){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from User where username=:name");
		query.setParameter("name", name);
		query.getFirstResult();
		List<User> users = query.list(); 
		session.close();
		if(users.size() != 0)
			return users.get(0);
		else 
			return null;
	}
	@Override
	public void updateUser(String name, String dish, String address, String password){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update User set password=:pass, dish=:favdish, address=:addr where username=:name");
		query.setParameter("name", name);
		query.setParameter("favdish", dish);
		query.setParameter("addr", address);
		query.setParameter("pass", password);
		query.executeUpdate();
		session.close();
	}
}
