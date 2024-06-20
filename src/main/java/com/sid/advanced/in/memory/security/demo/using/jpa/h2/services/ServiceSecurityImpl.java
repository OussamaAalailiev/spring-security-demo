package com.sid.advanced.in.memory.security.demo.using.jpa.h2.services;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.Role;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.RoleRepository;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class ServiceSecurityImpl implements UserService {
  
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;
  
  @Autowired
  public ServiceSecurityImpl(UserRepository userRepository,
                             RoleRepository roleRepository,
                             PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }
  
  @Override
  public User createUser(User user) {
    if (existsByEmail(user.getEmail())) {
      return null;
    }
    Role role = roleRepository.findById(1L).orElseThrow( () -> new RuntimeException("Role not found"));
    Set<Role> roles = new HashSet<>();
    if (role != null) {
      roles.add(role);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRoles(roles);
    }
    return userRepository.save(user);
  }
  
  private Boolean existsByEmail(String email) {
    //1- check if user's email is already in db:
    //2-1 If the user doesn't exist (new user) return false:
    //2-2 Otherwise if user's email is found duplicate return true.
    return userRepository.existsByEmail(email);
  }
  
}




















