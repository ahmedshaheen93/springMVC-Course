package com.shaheen.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class controllerAdvice {
    @ExceptionHandler(BaseException.class)
    public String handleApplicationException(BaseException ex, Model model, HttpServletResponse response) {
        model.addAttribute("message", ex.getMessage());
        model.addAttribute("error", ex.getHttpStatus());
        response.setStatus(ex.getHttpStatus().value());
        return "error";
    }

}
