package com.helloworld.models.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import com.helloworld.models.entity.User;
import com.helloworld.models.entity.UserRole;
import com.helloworld.models.repository.UserRepository;
import com.helloworld.models.service.validator.UserValidator;

@Service
public class UserService  {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserValidator userValidator;
	
	private void validate(User user, BindingResult result) {
		if (userRepository.findOneByUsername(user.getUsername()) != null) {
			result.rejectValue("username", "existing.username");
		}
		if (userRepository.findOneByEmail(user.getEmail()) != null) {
			result.rejectValue("email", "existing.email");
		}
	}

	public Boolean create(User user, BindingResult result) {
		userValidator.validate(user, result);
		validate(user, result);
		if (result.hasErrors()) {
			return false;
		} else {
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				byte[] messageDigest = md.digest(user.getPassword().getBytes());
				BigInteger number = new BigInteger(1, messageDigest);
				String hashtext = number.toString(16);
				while (hashtext.length() < 32) {
					hashtext = "0" + hashtext;
				}
				user.setPassword(hashtext);
				user.setId(UUID.randomUUID().toString());
				user.getUserRoles().add(UserRole.USER);

				userRepository.save(user);
			} catch (NoSuchAlgorithmException e) {
				throw new RuntimeException();
			}
		}
		return true;
	}

	public List<User> readAll() {
		return userRepository.findAll();
	}

	public User findOne(String username) {
		return userRepository.findOneByUsername(username);
	}

	public User update(User user) {
		User existingUser = userRepository.findOneByUsername(user.getUsername());
		existingUser.setFirstname(user.getFirstname());
		existingUser.setMiddlename(user.getMiddlename());
		existingUser.setLastname(user.getLastname());
		existingUser.setJob(user.getJob());
		existingUser.setEmail(user.getEmail());
		existingUser.setDepartment(user.getDepartment());
		return userRepository.save(existingUser);
	}

	public Boolean delete(String username) {
		User existingUser = userRepository.findOneByUsername(username);
		if (existingUser == null) {
			return false;
		}
		userRepository.delete(existingUser);
		return true;
	}

	
}
