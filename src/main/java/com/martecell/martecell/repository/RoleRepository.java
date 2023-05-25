package com.martecell.martecell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martecell.martecell.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);

}