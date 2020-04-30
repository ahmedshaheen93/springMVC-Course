package com.shaheen.controller;

import com.shaheen.model.User;
import com.shaheen.service.UserService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegistrationController extends SimpleFormController {

    private UserService userService;


    public RegistrationController() {
        setCommandClass(User.class);
        setCommandName("user");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public ModelAndView onSubmit(Object command, BindException bindException) throws Exception {
        User user = (User) command;
        userService.save(user);
        ModelAndView modelAndView = new ModelAndView(getSuccessView());
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
