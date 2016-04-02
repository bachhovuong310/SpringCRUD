package com.helloworld.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.helloworld.models.entity.User;
import com.helloworld.models.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String userList(ModelMap model) {
		model.addAttribute("userList", userService.readAll());
		return "user";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterForm(ModelMap model) {
		model.addAttribute("user", new User());
		return "registerForm";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String processRegistation(@ModelAttribute("user") User user, BindingResult result, SessionStatus status) {
		Boolean isCreated = userService.create(user, result);
		if (!isCreated) {
			return "registerForm";
		} else {
			status.setComplete();
			return "redirect:/user";
		}
	}

	@RequestMapping(value = "/{username}", method = RequestMethod.GET)
	public String showProfile(@PathVariable String username, ModelMap model) {
		if (!model.containsAttribute("currentUser")) {
			model.addAttribute("currentUser", userService.findOne(username));
		}
		return "profile";
	}

	@RequestMapping(value = "/{username}/edit", method = RequestMethod.GET)
	public String showEditForm(@PathVariable String username, ModelMap model) {
		model.addAttribute("currentUser", userService.findOne(username));
		return "edit";
	}

	@RequestMapping(value = "/{username}/edit", method = RequestMethod.POST)
	public String processEditUser(@ModelAttribute User currentUser) {
		userService.update(currentUser);
		return "redirect:/user";
	}

	@RequestMapping(value = "/delete/{username}", method = RequestMethod.GET)
	public String processDeleteUser(@PathVariable String username) {
		userService.delete(username);
		return "redirect:/user";
	}

}
