package com.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipes")
public class Recipe {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	int ID;
	@Column(name="title")
	String title;
	@Column(name="ingredients")
	String ingredients;
	@Column(name="steps")
	String steps;
	@Column(name="accessibility")
	String accessibility;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIngredients() {
		return ingredients;
	}
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	public String getAccessibility() {
		return accessibility;
	}
	public void setAccessibility(String accessibility) {
		this.accessibility = accessibility;
	}
	@Override
	public String toString() {
		return "Recipe [ID=" + ID + ", title=" + title + ", ingredients=" + ingredients + ", steps=" + steps
				+ ", accessibility=" + accessibility + "]";
	}
	
	
}
