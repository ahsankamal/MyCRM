package com.codegems.mycrm.repository;

import com.codegems.mycrm.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called customerRepository
// CRUD refers Create, Read, Update, Delete

@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    List<Customer> findByFirstName( @Param("firstName") String firstName);
}
