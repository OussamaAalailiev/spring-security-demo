package com.sid.advanced.in.memory.security.demo.using.jpa.h2.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Arrays;

import static org.springframework.security.config.Customizer.withDefaults;
import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.antMatcher;

// Security Config Class.
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  //Load user from the database h2.
  private CustomUserDetailsService customUserDetailsService;
  
  @Autowired
  public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
    this.customUserDetailsService = customUserDetailsService;
  }
  
  public SecurityConfig() {
  }
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(authorizeRequests ->
                    authorizeRequests
                            .requestMatchers(
                                    antMatcher("/public/**"),
                                    antMatcher("/h2-console/**"),
                                    antMatcher("/users")
                            ).permitAll()
                            .anyRequest().authenticated()
            )
//            .cors(AbstractHttpConfigurer::disable)
            .formLogin(withDefaults())
            .httpBasic(withDefaults())
            // this will ignore csrf for only the path of /h2-console, spring security 6.
            .csrf(httpSecurityCsrfConfigurer ->
                    httpSecurityCsrfConfigurer.ignoringRequestMatchers("/h2-console/**", "/users"))
            //this will allow frames with same origin which, is much more safe.
            .headers(httpSecurityHeadersConfigurer ->
                       httpSecurityHeadersConfigurer.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

    return http.build();
  }
  
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  
//  @Bean
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
  
}

















