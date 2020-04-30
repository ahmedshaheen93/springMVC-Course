package com.shaheen.controller;

import com.shaheen.model.User;
import com.shaheen.service.UserService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class UserReportController extends AbstractController {
    private UserService userService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> users = userService.findAll();
        return new ModelAndView("userReport", "users", users);
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

}
