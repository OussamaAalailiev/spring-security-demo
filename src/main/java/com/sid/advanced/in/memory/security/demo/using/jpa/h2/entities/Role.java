package com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "roles")
public class Role {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  //Marking the field "users" that owns the relationship with (mappedBy = "roles"),
  // so that the relationship is bidirectional.
  @JsonIgnore
  @ManyToMany(mappedBy = "roles")
  private Set<User> users;
  
  public Long getId() {
    return id;
  }
  
  public void setId(Long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public Set<User> getUsers() {
    return users;
  }
  
  public void setUsers(Set<User> users) {
    this.users = users;
  }
}
