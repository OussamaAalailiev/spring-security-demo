package com.sid.advanced.in.memory.security.demo.using.jpa.h2.initDataSecurity;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.Role;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.RoleRepository;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

/*
You can initialize the in-memory database with
  some users and roles by creating a data initialization class.
 */
@Configuration
public class DataInitializer {
  
  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private PasswordEncoder passwordEncoder;
  
  @Autowired
  public DataInitializer(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }
  public DataInitializer() {
  }
  
  @PostConstruct
  public void init() {
    //Role 1:
    Role userRole = new Role();
    userRole.setName("ROLE_USER");
    roleRepository.save(userRole);
    //Role 2:
    Role adminRole = new Role();
    adminRole.setName("ROLE_ADMIN");
    roleRepository.save(adminRole);
    //Role 3:
    Role superAdminRole = new Role();
    superAdminRole.setName("ROLE_SUPER_ADMIN");
    roleRepository.save(superAdminRole);
    
    //user 1:
    User user = new User();
    user.setEmail("user@email.com");
    String myPasswordEncoder = passwordEncoder.encode("password");
    user.setPassword(myPasswordEncoder);
    Set<Role> roles = new HashSet<>();
    roles.add(userRole);
    user.setRoles(roles);
    userRepository.save(user);
    //user 2:
    User admin = new User();
    admin.setEmail("userAdmin@email.com");
    admin.setPassword(passwordEncoder.encode("admin"));
    Set<Role> roles2 = new HashSet<>();
    roles2.add(userRole); roles2.add(adminRole);
    admin.setRoles(roles2);
    userRepository.save(admin);
    //user 3:
    User superAdmin = new User();
    superAdmin.setEmail("userSuperAdmin@email.com");
    superAdmin.setPassword(passwordEncoder.encode("superAdmin"));
    Set<Role> roles3 = new HashSet<>();
    roles3.add(userRole); roles3.add(adminRole); roles3.add(superAdminRole);
    superAdmin.setRoles(roles3);
    userRepository.save(superAdmin);
    
  }
  
}














