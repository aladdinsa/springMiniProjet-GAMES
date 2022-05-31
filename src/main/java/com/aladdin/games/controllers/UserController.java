package com.aladdin.games.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.aladdin.games.entities.User;
import com.aladdin.games.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping("/CreateUser")
	public String CreateUser(ModelMap modelMap) {

		modelMap.addAttribute("user", new User());
		modelMap.addAttribute("mode", "new");

		return "formUser";
	}

	@RequestMapping("/saveUser")
	public String saveUser(User user) {
		userService.saveUser(user);
		return "ListeUsers";
	}

	@RequestMapping("/ListeUsers")
	public String listeUsers(ModelMap modelMap, @RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<User> u = userService.getAllUsersParPage(page, size);
		modelMap.addAttribute("users", u);
		modelMap.addAttribute("pages", new int[u.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeUsers";
	}

	@RequestMapping("/supprimerUser")
	public String supprimerUsers(@RequestParam("id") Long id, ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		userService.deleteUserById(id);
		Page<User> u = userService.getAllUsersParPage(page, size);
		modelMap.addAttribute("users", u);
		modelMap.addAttribute("pages", new int[u.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listegenre";
	}

	@RequestMapping("/modifierUser")
	public String editerUser(@RequestParam("id") Long id, ModelMap modelMap) {
		User u = userService.getUser(id);
		modelMap.addAttribute("users", u);
		modelMap.addAttribute("mode", "edit");
		return "formUser";
	}

	@RequestMapping("/updateUser")
	public String updateUser(@ModelAttribute("user") User user, ModelMap modelMap) throws ParseException {

		userService.updateUser(user);
		List<User> u = userService.getAllUsers();
		modelMap.addAttribute("users", u);
		return "listeUsers";
	}

}
