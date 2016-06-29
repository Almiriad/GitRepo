package com.spr.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spr.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> classT) {
		return User.class.isAssignableFrom(classT);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "user.creation.mail.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.creation.password.empty");
	}
	

}
