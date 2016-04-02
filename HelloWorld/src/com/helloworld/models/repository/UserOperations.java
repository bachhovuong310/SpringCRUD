package com.helloworld.models.repository;

import com.helloworld.models.entity.User;

public interface UserOperations {
	User findOneByUsername(String username);
	User findOneByEmail(String email);
	void deleteUserByUsername(String username);
	
}
