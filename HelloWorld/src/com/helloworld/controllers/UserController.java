package com.helloworld.controllers;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
		User resultUser = userService.findOne(username);
		if (resultUser != null){
			model.addAttribute("currentUser", resultUser);
			model.addAttribute("foundUser",true);
		}else{
			model.addAttribute("notFoundUser", true);
			model.addAttribute("usernameNotFound", username);
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

	// @RequestMapping(value="/logout", method = RequestMethod.GET)
	// public String logoutPage(HttpServletRequest req, HttpServletResponse
	// res){
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// if(auth!=null){
	// new SecurityContextLogoutHandler().logout(req, res, auth);
	// }
	// return "redirect:";
	// }
	// @RequestMapping(value="/Access_Denied", method = RequestMethod.GET)
	// public String accessDeniedPage(ModelMap model){
	//
	// return "accessDenied";
	// }
}
