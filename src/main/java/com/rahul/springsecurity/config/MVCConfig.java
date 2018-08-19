package com.rahul.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MVCConfig implements WebMvcConfigurer{

	
    @Override

    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/home").setViewName("home");

        registry.addViewController("/").setViewName("home");

        registry.addViewController("/hello").setViewName("firstpage");

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/sessionExpired").setViewName("sessionExpired");
        registry.addViewController("/invalid").setViewName("invalid");

    }
	@Bean
	public InternalResourceViewResolver viewResolver() {

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();

		resolver.setPrefix("/WEB-INF/views/");

		resolver.setSuffix(".jsp");

		return resolver;

	}

}
