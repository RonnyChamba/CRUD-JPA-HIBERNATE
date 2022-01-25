package com.ideas.app.conf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
 
@Configuration
@ComponentScan(basePackages = {"com.ideas.app.conf", "com.ideas.app.controller"})
@EnableWebMvc
public class WebAppConfi implements WebMvcConfigurer {
	
  	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		
		registry.addResourceHandler("/static/**")
				.addResourceLocations("/WEB-INF/resources/");
	}
	
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {	
		registry.jsp("/WEB-INF/views/", ".jsp");
	
	}
}
