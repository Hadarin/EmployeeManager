package com.hadrin.employeedemo.rest;

import com.hadrin.employeedemo.entity.Employee;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

/**
 * This class provides permission to the id in the REST HATEOAS service (Spring Data).
 * @author Igor Hadarin
 * @version 1.0
 */
@Component
public class ExposeEntityIdRestMvcConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Employee.class);
    }
}