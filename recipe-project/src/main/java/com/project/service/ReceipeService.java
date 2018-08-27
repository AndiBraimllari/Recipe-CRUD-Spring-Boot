package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.dao.RecipeDAOAbst;
import com.project.model.Recipe;
import com.project.service.ReceipeServiceAbst;

@Service
public class ReceipeService implements ReceipeServiceAbst{
	@Autowired
	RecipeDAOAbst recipedao;

	@Override
	public void save(Recipe recipe) {
		if(recipe.getAccessibility().contains("private"))
			recipe.setAccessibility("private");
		recipedao.save(recipe);
	}
	@Override
	public List<Recipe> getRecipesList(){
		return recipedao.getRecipesList();
	}
	@Override
	public void deleteRecipe(int id){
		recipedao.deleteRecipe(id);
	}
	@Override
	public Recipe getRecipe(String title){
		return recipedao.getRecipe(title);
	}
	@Override
	public Recipe getRecipeByID(int id){
		Recipe rec = recipedao.getRecipeByID(id);
		return rec;
	}
	@Override
	public void updateRecipe(int id, String title, String ingredients, String steps){
		recipedao.updateRecipe(id, title, ingredients, steps);
	}
}
