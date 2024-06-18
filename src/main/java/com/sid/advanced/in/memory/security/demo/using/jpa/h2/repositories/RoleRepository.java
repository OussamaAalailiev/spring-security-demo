package com.sid.advanced.in.memory.security.demo.using.jpa.h2.repositories;

import com.sid.advanced.in.memory.security.demo.using.jpa.h2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
