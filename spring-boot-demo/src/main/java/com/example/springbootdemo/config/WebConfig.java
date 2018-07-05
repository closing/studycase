package com.example.springbootdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	HandlerInterceptor timeInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor);
	}

	// WebSocket1
	//	@Bean
	//	public ServerEndpointExporter serverEndpointExporter() {
	//		return new ServerEndpointExporter();
	//	}
	// CORS
	//
	//	@Override
	//	public void addCorsMappings(CorsRegistry registry) {
	//		registry.addMapping("/json/**")
	//				.allowedOrigins("http://localhost:8088");
	//	}

	//	@Bean
	//	public ServletRegistrationBean<Servlet> servletRegistrationBean() {
	//		return new ServletRegistrationBean<>(new ServletTest(), "/servletTest");
	//	}

}
