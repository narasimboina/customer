package com.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

public class CustomerServiceImpl {

    @Autowired
    private final CustomerRepository customerRepository;

    /**
     * all Customers
     * @return
     */
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }

    /**
     * getCustomer
     * @param id
     * @return
     */
    public Customer getCustomer(Long id){
        return customerRepository.findById(id);
    }

    /**
     * createCustomer
     * @param customer
     * @return
     */
    public Customer saveCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    /**
     * deleteCustomer
     * @param id
     */
    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    /**
     * update customer
     * @param customer
     * @param id
     * @return
     */
    public Customer updateCustomer(Customer customer, Long id){
        return customerRepository.findById(id)
                .map( cust -> {
                    cust.setName(customer.getName());
                    return repository.save(cust);
                })
                .orElseGet(() -> {
                    customer.setId(id);
                    return customerRepository.save(customer);
                });
    }

}