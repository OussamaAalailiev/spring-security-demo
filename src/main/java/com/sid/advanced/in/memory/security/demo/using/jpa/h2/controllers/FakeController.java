package com.sid.advanced.in.memory.security.demo.using.jpa.h2.controllers;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.Role;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.RoleRepository;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.UserRepository;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FakeController {
  
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final UserService userService;
  private final PasswordEncoder passwordEncoder;
  
  @Autowired
  public FakeController(UserRepository userRepository,
                        RoleRepository roleRepository,
                        UserService userService,
                        PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.userService = userService;
    this.passwordEncoder = passwordEncoder;
  }
  
  @GetMapping(path = "/public")
  public String get_public() {
    return "Public";
  }
  
  @GetMapping(path = "/public/7awli")
  public List<String> getAll_public() {
    return List.of("7awli bargi", "7awli Sardi", "7awli Romany", "7awli Espagnole");
  }
  
  @GetMapping(path = "/private/api")
  public List<String> getAll_NotPublic() {
    return List.of("admin1", "admin2", "admin3", "user1", "user2");
  }
  
  @PostMapping(path = "/users")
  public User createSimpleUser(@RequestBody User user) {
    System.out.println(user.toString());
    return this.userService.createUser(user);
  }
  
}
