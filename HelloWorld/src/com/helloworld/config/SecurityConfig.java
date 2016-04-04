package com.helloworld.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import com.helloworld.models.repository.UserRepository;
import com.helloworld.models.service.MongoUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(new MongoUserDetailsService(userRepository))
		.passwordEncoder(passwordEncoder());
		
//		auth.inMemoryAuthentication().withUser("admin").password("123456").roles("ADMIN");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
				.antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
				.and().formLogin().loginPage("/loginPage").defaultSuccessUrl("/user").failureUrl("/loginPage?error")
				.usernameParameter("username").passwordParameter("password").and().logout()
				.logoutSuccessUrl("/loginPage?logout");
	}
	@Bean(name="passwordEncoder")
	public PasswordEncoder passwordEncoder(){
		return new Md5PasswordEncoder();
	}
}
