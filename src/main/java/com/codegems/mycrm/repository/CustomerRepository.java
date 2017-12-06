package com.codegems.mycrm.repository;

import com.codegems.mycrm.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called customerRepository
// CRUD refers Create, Read, Update, Delete
public interface CustomerRepository extends CrudRepository<Customer,Long>{
    List<Customer> findByFirstName(String firstName);
}
