package com.shaheen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "com.shaheen")
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver internalResourceViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("messages", "errors");
        resourceBundleMessageSource.setFallbackToSystemLocale(true);
        resourceBundleMessageSource.setDefaultLocale(new Locale("en_US"));
        resourceBundleMessageSource.setDefaultEncoding("UTF-8");
        resourceBundleMessageSource.setCacheSeconds(3600);
        return resourceBundleMessageSource;
    }
}
