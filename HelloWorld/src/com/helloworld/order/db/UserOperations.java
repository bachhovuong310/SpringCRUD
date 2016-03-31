package com.helloworld.order.db;

import com.helloworld.order.User;

public interface UserOperations {
	User findOneByUsername(String username);
	void deleteUserByUsername(String username);

}
