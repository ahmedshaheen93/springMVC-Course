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
        if (user.getSalary() == null || user.getSalary() < 2000) {
            errors.rejectValue("salary", "error.user.salary", "salary must be greater than 2000");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "error.user.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "error.user.lastName");
    }
}
