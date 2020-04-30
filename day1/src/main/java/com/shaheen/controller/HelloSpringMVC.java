package com.shaheen.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloSpringMVC extends AbstractController {
    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest,
                                                 HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView modelAndView = new ModelAndView("helloSpringMVC");
        modelAndView.addObject("msg",
                "Welcome to first Spring WebMVC application");
        return modelAndView;
    }
}
