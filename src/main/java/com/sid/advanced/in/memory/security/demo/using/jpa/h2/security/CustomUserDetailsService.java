package com.sid.advanced.in.memory.security.demo.using.jpa.h2.security;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
/** Implement the 'UserDetailsService' interface to load user-specific data by email. */
/*
A custom UserDetailsService to load user details from the database.
  This is a more scalable and flexible approach compared to hardcoding user details.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
  
  private final UserRepository userRepository;
  
  @Autowired
  public CustomUserDetailsService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }
  
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByEmail(username);//username = email for me, because I want to fetch user by email.
    if (user == null) {
      throw new UsernameNotFoundException("User not found");
    }
    
    return new org.springframework.security.core.userdetails.User(
          user.getEmail(),
          user.getPassword(),
          user.getRoles().stream()
                  .map(role -> new SimpleGrantedAuthority(role.getName()))
                  .collect(Collectors.toList())
    );
  }
}

















