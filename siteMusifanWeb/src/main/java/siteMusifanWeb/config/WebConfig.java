package siteMusifanWeb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import siteMusifan.config.AppConfig;

@Configuration
@EnableWebMvc
@ComponentScan("siteMusifanWeb.controller")
@Import(AppConfig.class)
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/images/**").addResourceLocations("/assets/images/");
		registry.addResourceHandler("/assets/css/**").addResourceLocations("/assets/css/");
	}
	
	@Bean
	public UrlBasedViewResolver viewResolver() {
		UrlBasedViewResolver uBVR =  new UrlBasedViewResolver();
		uBVR.setViewClass(JstlView.class);
		uBVR.setPrefix("/WEB-INF/views/");
		uBVR.setSuffix(".jsp");
		return uBVR;
	}
}
