package com.helloworld.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.helloworld.order.User;
import com.helloworld.order.db.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserRepository repository;
	@RequestMapping(value ="", method = RequestMethod.GET)
	public String userList(ModelMap model){
		model.addAttribute("userList", repository.findAll());
		return "user";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.GET)
	public String showRegisterForm(){
		return "registerForm";
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public String processRegistation(User user){
		try{
			user.setId(UUID.randomUUID().toString());
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(user.getPassword().getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            user.setPassword(hashtext);
            repository.insert(user);
            return "redirect:/user";
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping(value="/{username}", method = RequestMethod.GET)
	public String showProfile(@PathVariable String username, ModelMap model){
		User currentUser = repository.findOneByUsername(username);
		model.addAttribute("currentUser", currentUser);
		return "profile";
	}
	
	@RequestMapping(value="/{username}/edit", method = RequestMethod.GET)
	public String showEditForm(@PathVariable String username, ModelMap model){
		User currentUser = repository.findOneByUsername(username);
		model.addAttribute("currentUser", currentUser);
		return "edit";
	}
	
	@RequestMapping(value="/{username}/edit", method = RequestMethod.POST)
	public String processEditUser(@ModelAttribute User currentUser){
		User existingUser = repository.findByUsername(currentUser.getUsername());
		existingUser.setFirstname(currentUser.getFirstname());
		existingUser.setMiddlename(currentUser.getMiddlename());
		existingUser.setLastname(currentUser.getLastname());
		existingUser.setJob(currentUser.getJob());
		existingUser.setEmail(currentUser.getEmail());
		existingUser.setDepartment(currentUser.getDepartment());
		repository.save(existingUser);
		return "redirect:/user";
	}
	
	@RequestMapping(value="/delete/{username}", method = RequestMethod.GET)
	public String processDeleteUser(@PathVariable String username){
		repository.deleteUserByUsername(username);
		return "redirect:/user";
	}

}
