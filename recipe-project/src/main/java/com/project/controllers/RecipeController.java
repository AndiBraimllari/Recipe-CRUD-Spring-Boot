package com.project.controllers;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.project.model.Recipe;
import com.project.model.User;
import com.project.service.ReceipeServiceAbst;
import com.project.service.UserServiceAbst;

@Controller
public class RecipeController {
	static int idToUpdate = -1;
	static String userName;
	Logger log = LogManager.getLogger(RecipeController.class);
	@Autowired
	ReceipeServiceAbst receipeService;
	@Autowired
	UserServiceAbst userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)  // andi andi for admin
    public String login(Model model, String error, String logout) {  // user user for user
        if (error != null)
            model.addAttribute("errorMsg", "Your username and password are invalid.");

        if (logout != null)
            model.addAttribute("msg", "You have been logged out successfully.");

        return "login";
    }
	@RequestMapping(value="/welcome", method=RequestMethod.GET)
	public ModelAndView firstPage() {
		List<Recipe> recipes = receipeService.getRecipesList();
		log.info("log4j enabled");
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("recipes", recipes);
		return model;
	}

	@RequestMapping(value="/welcome", method=RequestMethod.POST)
	public void controllerMethod(@RequestParam(value="id") int idToDelete){
	    receipeService.deleteRecipe(idToDelete);
	}
	@RequestMapping(value = "/addRecipe", method = RequestMethod.GET)
	public ModelAndView show() {
		return new ModelAndView("addRecipe");
	}

	@RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
	public ModelAndView processRequest(@RequestParam("id") String id, @RequestParam("title")String title,
			@RequestParam("ing")String ingredients, @RequestParam("steps")String steps,
			@RequestParam("privateCheckbox") String accessibility) {
		Recipe recipe = new Recipe();
		if(id.equals(""))
			recipe.setID(0);
		else
			recipe.setID(Integer.parseInt(id));
		recipe.setTitle(title);
		recipe.setIngredients(ingredients);
		recipe.setSteps(steps);
		recipe.setAccessibility(accessibility);
		receipeService.save(recipe);
		return new ModelAndView("addRecipe");
	}

	@RequestMapping(value="/updateRecipeID", method=RequestMethod.POST) // jsp for this doesnt exist
	public void updateRecipeAJAX(@RequestParam(value="mynum") int idToUpdate){
		RecipeController.idToUpdate = idToUpdate;
	}
	@RequestMapping(value="/updateRecipe", method=RequestMethod.GET)
	public ModelAndView updateRecipeGET(){
		ModelAndView model = new ModelAndView("updateRecipe");
		Recipe recipe = receipeService.getRecipeByID(idToUpdate);
		model.addObject("recipe", recipe);
		model.addObject("idToUpdate", idToUpdate);
		return model;
	}
	@RequestMapping(value="/updateRecipe", method=RequestMethod.POST)
	public void updateRecipePOST(@RequestParam(value="titleToUpdate") String titUpd,
			@RequestParam(value="ingToUpdate") String ingUpd, 
			@RequestParam(value="stepsToUpdate") String stepsUpd){
		receipeService.updateRecipe(idToUpdate, titUpd, ingUpd, stepsUpd);
		idToUpdate = -1; // Reset the id of the recipe to be updated after we updated our current one
	}
	
	@RequestMapping(value="/getRecipe", method=RequestMethod.GET)
	public ModelAndView getRecipe(){
		return new ModelAndView("getRecipe");
	}
	@RequestMapping(value="/getRecipe", method=RequestMethod.POST)
	public ModelAndView getRecipePOST(@RequestParam("search-recipe") String searchTitle){
		ModelAndView model = new ModelAndView("getRecipe");
		Recipe recipe = receipeService.getRecipe(searchTitle);
		model.addObject("recipe", recipe);
		return model;
	}
	@RequestMapping(value="/settings", method=RequestMethod.GET)
	public ModelAndView getSettings(Principal princ){
		userName = princ.getName();
		User user = userService.getUser(userName);
		ModelAndView model = new ModelAndView("settings");
		model.addObject("user", user);
		return model;
	}
	@RequestMapping(value="/settings", method=RequestMethod.POST)
	public void updateSettingsAJAX(@RequestParam("passParam") String password,
			@RequestParam("dishParam") String dish, @RequestParam("addressParam") String address){
		userService.updateUser(userName, dish, address, password);
	}
}