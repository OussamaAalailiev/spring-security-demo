package com.sid.advanced.in.memory.security.demo.using.jpa.h2.controllers;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.Role;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.RoleRepository;
import com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories.UserRepository;
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
  private final PasswordEncoder passwordEncoder;
  
  @Autowired
  public FakeController(UserRepository userRepository,
                        RoleRepository roleRepository,
                        PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
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
    Role role = roleRepository.findById(1L).orElseThrow( () -> new RuntimeException("Role not found"));
    Set<Role> roles = new HashSet<>();
    if (role != null) {
      roles.add(role);
      user.setPassword(passwordEncoder.encode(user.getPassword()));
      user.setRoles(roles);
    }
    return this.userRepository.save(user);
  }
  
}
