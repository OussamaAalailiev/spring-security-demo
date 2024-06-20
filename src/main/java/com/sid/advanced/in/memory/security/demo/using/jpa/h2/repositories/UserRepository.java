package com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
  
  // Méthode pour vérifier si un email existe:
  @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.email = :email")
  boolean existsByEmail(@Param("email") String email);
}
