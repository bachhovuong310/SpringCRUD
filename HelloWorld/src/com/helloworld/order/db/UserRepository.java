package com.helloworld.order.db;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.helloworld.order.User;

public interface UserRepository extends MongoRepository<User, String>, UserOperations {
	User findByUsername(String username);
	
}
