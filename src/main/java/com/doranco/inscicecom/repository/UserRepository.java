package com.doranco.inscicecom.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.doranco.inscicecom.enums.UserRole;
import com.doranco.inscicecom.model.User;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findFirstByEmail(String email);

    // Only Used to check of ADMIN exists (running for first time)
    Optional<User> findByRole(UserRole userRole);

}
