package com.hadrin.employeedemo.entity;

import javax.persistence.*;
import java.util.Set;

/**
 * Simple POJO Employee for CRUD operations.
 * @author Igor Hadarin
 * @version 1.0
 */
@Entity
@Table (name = "language")
public class Language {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String languageName;

    @ManyToMany(mappedBy = "languages")
    private Set<Employee> employees;

    public Language () {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
