package com.project.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.project.model.Recipe;

//@Repository remove bean in config for this not to throw and exception
public class RecipeDAO implements RecipeDAOAbst{
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Recipe recipe){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(recipe);
		transaction.commit();
		session.close();
	}
	@Override
	@SuppressWarnings("unchecked")
	public List<Recipe> getRecipesList(){
		Session session = sessionFactory.openSession();
		List<Recipe> list = session.createQuery("from Recipe order by creation_date desc").list();
		session.close();
		int max = list.size();
		if(max > 10)
			max = 10;
		return list.subList(0, max);
	}
	@Override
	public void deleteRecipe(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("delete Recipe where ID=:id");
		query.setParameter("id", id);
		int result = query.executeUpdate();
		if(result == 1)
			System.out.println("Deletion was successful");
	}
	@Override
	@SuppressWarnings("unchecked")
	public Recipe getRecipe(String title){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Recipe where title=:titleDel and accessibility=:access");
		query.setParameter("titleDel", title);
		query.setParameter("access", "public");
		query.getFirstResult();
		List<Recipe> recs = query.list();
		session.close();
		if(recs.size() != 0)
			return recs.get(0);
		else 
			return null;
	}
	@Override
	@SuppressWarnings("unchecked")
	public Recipe getRecipeByID(int id){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from Recipe where ID=:id");
		query.setParameter("id", id);
		query.getFirstResult();
		List<Recipe> rec = query.list();
		session.close();
		if(rec.size() != 0)
			return rec.get(0);
		else
			return null;
	}
	@Override
	public void updateRecipe(int id, String title, String ingredients, String steps){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("update Recipe set title=:tit,ingredients=:ing, steps=:stp  where ID=:id");
		query.setParameter("tit", title);
		query.setParameter("ing", ingredients);
		query.setParameter("stp", steps);
		query.setParameter("id", id);
		int a = query.executeUpdate();
		System.out.println(a);
	}
}
