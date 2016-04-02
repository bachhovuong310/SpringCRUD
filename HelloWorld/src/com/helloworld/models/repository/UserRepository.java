package com.helloworld.models.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.helloworld.models.entity.User;


public interface UserRepository extends MongoRepository<User, String>, UserOperations {
	
}
