package com.sid.advanced.in.memory.security.demo.using.jpa.h2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class AdvancedInMemorySecurityDemoUsingJpaH2Application {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedInMemorySecurityDemoUsingJpaH2Application.class, args);
	}
	
//	@Bean
//	CorsConfigurationSource corsConfigurationSource() {
//		CorsConfiguration configuration = new CorsConfiguration();
//		configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//		configuration.setAllowedMethods(Arrays.asList("*"));
//		configuration.setAllowedHeaders(Arrays.asList("*"));
//		configuration.setAllowCredentials(true);
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		source.registerCorsConfiguration("/**", configuration);
//		return source;
//	}
	
	/**CORS Global Configuration: */
//	@Bean
//	public CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration corsConfiguration = new CorsConfiguration();
//		corsConfiguration.setAllowCredentials(true);
//		corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
//		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
//						"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
//						"Access-Control-Request-Method", "Access-Control-Request-Headers"));
//		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
//						"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "File-Name"));
//		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
//		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
//		return new CorsFilter(urlBasedCorsConfigurationSource);
//	}

}
