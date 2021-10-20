package com.customer.api;

public interface CustomerService {

    public List<Customer> findAllCustomers();
    public Customer getCustomer(Long id);
    public Customer saveCustomer(Customer customer);
    public void deleteCustomer(Long id);
    public Customer updateCustomer(Customer customer, Long id);

}