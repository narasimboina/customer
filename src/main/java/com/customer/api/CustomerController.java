package com.customer.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAllCustomers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findCustomerById(@PathVariable(value = "id") long id) {

        Optional<Customer> customer = customerService.getCustomer(id);
       //validate
        if(customer.isPresent()) {
            return ResponseEntity.ok().body(customer.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Customer createCustomer(@Validated @RequestBody Customer customer) {
        return customerService.saveCustomer(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@Validated @RequestBody Customer customer, @PathVariable(value = "id") long id) {
        return customerService.updateCustomer(customer, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable(value = "id") long id) {
        customerService.deleteCustomer(id);
    }
}