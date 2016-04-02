package com.helloworld.models.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.helloworld.models.entity.User;


public class UserRepositoryImpl implements UserOperations{
	@Autowired
	private MongoOperations mongo;
	
	
	public User findOneByUsername(String username) {
		Criteria where = Criteria.where("username").is(username);
		Query query = Query.query(where);
		return mongo.findOne(query, User.class);
	}
	public User findOneByEmail(String email) {
		Criteria where = Criteria.where("email").is(email);
		Query query = Query.query(where);
		return mongo.findOne(query, User.class);
	}
	public void deleteUserByUsername(String username) {
		Criteria where = Criteria.where("username").is(username);
		Query query = Query.query(where);
		mongo.remove(query);
	}
	
}
