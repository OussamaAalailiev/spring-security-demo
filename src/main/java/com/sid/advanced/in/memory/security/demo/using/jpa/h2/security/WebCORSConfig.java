package com.sid.advanced.in.memory.security.demo.using.jpa.h2.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebCORSConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200") // your reactjs URL
            .allowedMethods("GET", "POST", "PATCH", "PUT", "DELETE")
            .allowedHeaders("Content-Type") // Adjust headers you need to allow
            .allowCredentials(true); // Add only if you want to access cookie
  }
}
