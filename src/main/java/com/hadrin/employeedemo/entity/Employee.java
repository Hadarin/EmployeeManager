package com.hadrin.employeedemo.entity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

/**
 * Simple POJO Employee for CRUD operations.
 * @author Igor Hadarin
 * @version 1.0
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "is required")
    @Size(min = 2, max = 50, message = "Please input at least 2 and at most 50 characters.")
    @Column(name ="first_name")
    private String firstName;


    @NotEmpty(message = "is required")
    @Size(min = 2, max = 50, message = "Please input at least 2 and at most 50 characters.")
    @Column(name="last_name")
    private String lastName;

    @NotNull(message = "is required")
    @Column(name="salary")
    private Long salary;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "employee_language",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "language_id")
    )
    private Set<Language> languages;

    public Employee () {}

    public Employee (int id, String firstName, String lastName, Long salary, Set<Language> languages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.languages = languages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public Set<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(Set<Language> languages) {
        this.languages = languages;
    }
}
