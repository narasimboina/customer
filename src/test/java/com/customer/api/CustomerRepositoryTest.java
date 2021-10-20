package com.customer.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;
import org.junit.Assert.assertNotNull;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCustomerByIdExists() {
        customerRepository.save(new Customer("Dave"));
        assertNotNull(customerRepository.findById(1L));
    }

    @Test
    public void tesgetAllCustomer() {
        customerRepository.save(new Customer("Dave"));
        customerRepository.save(new Customer("Dake"));
        assertNotNull(customerRepository.findAll());
    }
}