package com.hadrin.employeedemo.dao;

import com.hadrin.employeedemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository provides DAO for the User entity.
 * @author Igor Hadarin
 * @version 1.0
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
