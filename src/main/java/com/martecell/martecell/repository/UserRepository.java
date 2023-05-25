package com.martecell.martecell.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martecell.martecell.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}