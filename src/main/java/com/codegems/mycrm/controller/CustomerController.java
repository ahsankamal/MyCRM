package com.codegems.mycrm.controller;

import com.codegems.mycrm.model.Customer;
import com.codegems.mycrm.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/*@RestController //@Controller + @ResponseBody (returns data rather than a view)*/
@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/greeting")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path = {"/add"},method=GET)
    @ResponseBody
    public String addCustomer(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email){
    Customer c = new Customer();
    c.setFirstName(firstName);
    c.setLastName(lastName);
    c.setEmail(email);
    customerRepository.save(c);
    return "saved";
    //http://localhost:8080/customer/add?firstName=ahsan&lastName=kamal&email=ahsan.kamal@payu.in

    }

    @GetMapping(path="/all")
    @ResponseBody
    public Iterable<Customer> getAllUsers() {
        // This returns a JSON or XML with the users
        return customerRepository.findAll();
    }

    @RequestMapping(method = GET, value = {"/list", "/"})
    public String listCustomers(Model m){
        return "customer/index";
    }
}
