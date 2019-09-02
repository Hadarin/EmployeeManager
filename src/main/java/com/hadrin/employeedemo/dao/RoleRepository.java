package com.hadrin.employeedemo.dao;

import com.hadrin.employeedemo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository provides DAO for the Role entity.
 * @author Igor Hadarin
 * @version 1.0
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);

}
