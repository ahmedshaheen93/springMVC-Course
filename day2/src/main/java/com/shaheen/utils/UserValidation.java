package com.shaheen.utils;

import com.shaheen.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(User.class);
    }

    @Override
    public void validate(Object object, Errors errors) {
        User user = (User) object;
        if (user.getFirstName() == null || user.getFirstName().trim().equals("")) {
            errors.rejectValue("firstName", "user.firstName", "can't be null or empty");
        }
        ValidationUtils.rejectIfEmpty(errors, "firstName", "can't be null or empty");

    }
}
