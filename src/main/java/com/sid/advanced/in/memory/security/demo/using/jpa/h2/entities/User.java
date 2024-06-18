package com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities;

import jakarta.persistence.*;

import java.util.Set;
@Entity
@Table(name = "users")
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(nullable = false, unique = true)
  private String email;
  @Column(nullable = false)
  private String password;
  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "users_roles",
             joinColumns = @JoinColumn(name = "user_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getPassword() {
    return password;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }
  
  public Set<Role> getRoles() {
    return roles;
  }
  
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  
  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +//'password' Should be erased later /!\.
            ", roles=" + roles +
            '}';
  }
}
