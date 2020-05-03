package com.shaheen.config;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;


public class AnnotationWebAppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) {
        // root app context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(AppConfig.class);

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(MvcConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcherServlet", dispatcherServlet);

        dynamic.addMapping("*.htm");
        dynamic.setLoadOnStartup(1);

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

}
