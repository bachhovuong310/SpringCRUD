package com.helloworld.models.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
@EnableMongoRepositories(basePackages = "com.helloworld.models.repository",
						 repositoryImplementationPostfix="Stuff")
public class MongoConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "test";
	}
	
	@Override
	public Mongo mongo() throws Exception {
		return new MongoClient();
	}

}