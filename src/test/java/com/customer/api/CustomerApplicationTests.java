package com.customer.api;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CustomerController.class)
class CustomerApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;


	@Test
	void whenGetCustomer_returnJsonContent() throws Exception {

		Customer customer = new Customer("Dave");
		customer.setId(1L);
		when(customerService.getCustomer(1L)).thenReturn(customer);

		this.mockMvc.perform(get("/api/customer/1"))
				.andExpect(status().isOk())
				.andDo(print());
	}

}
