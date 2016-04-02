package com.helloworld.models.service.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import com.helloworld.models.entity.User;


public class UserValidator implements Validator{
	
	@Override
	public boolean supports(Class clazz) {
		//just validate the User instances
		return User.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","required.username");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required.password");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password_confirmation","required.password_confirmation");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "required.firstname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middlename", "required.middlename");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "required.lastname");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job", "required.job");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "department", "required.department");
		User user =(User) target;
		if(!user.getPassword().equals(user.getPassword_confirmation())){
			errors.rejectValue("password","notmatch.password");
		}
		if(user.getUsername().length() > 16){
			errors.rejectValue("username", "size.username");
		}
	}
}
