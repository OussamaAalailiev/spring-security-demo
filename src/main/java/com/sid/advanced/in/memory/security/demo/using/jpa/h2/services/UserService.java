package com.sid.advanced.in.memory.security.demo.using.jpa.h2.services;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;

public interface UserService {
  
  User createUser(User user);
//  Boolean existsByEmail(String email);
  
}
