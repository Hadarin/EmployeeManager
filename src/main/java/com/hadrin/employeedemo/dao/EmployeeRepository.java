package com.hadrin.employeedemo.dao;

import com.hadrin.employeedemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * JPA repository provides DAO for the Employee entity.
 * @author Igor Hadarin
 * @version 1.0
 */
@Repository
@RepositoryRestResource(path = "employees")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /**
     *Retrieve employees ordered be last name
     * With link /api/employees/search/lastname
     */
    @RestResource(path = "lastname")
    List<Employee> findAllByOrderByLastNameAsc();

}
