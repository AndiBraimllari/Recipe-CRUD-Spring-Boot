package com.project.service;

import java.util.List;

import com.project.model.Recipe;

public interface ReceipeServiceAbst {
	public void save(Recipe recipe);
	public List<Recipe> getRecipesList();
	public void deleteRecipe(int id);
	public Recipe getRecipe(String title);
	public Recipe getRecipeByID(int id);
	public void updateRecipe(int id, String title, String ingredients, String steps);
}
