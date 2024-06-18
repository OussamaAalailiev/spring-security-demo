package com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}
