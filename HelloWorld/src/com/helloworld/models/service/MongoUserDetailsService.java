package com.helloworld.models.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.helloworld.models.entity.User;
import com.helloworld.models.entity.UserRole;
import com.helloworld.models.repository.UserRepository;

public class MongoUserDetailsService implements UserDetailsService {
	private final UserRepository userRepository;

	public MongoUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findOneByUsername(username);
		if (user == null) {
			System.out.println("Username not found");
			throw new UsernameNotFoundException("Username not found");
		} else {
			return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
					getGrantedAuthorities(user));
		}
	}

	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserRole role : user.getUserRoles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
		}
		System.out.println("authorities :" + authorities);
		return authorities;
	}
}
