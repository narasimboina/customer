package com.customer.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadData {

	private static final Logger log = LoggerFactory.getLogger(LoadData.class);

	@Bean
	CommandLineRunner initDatabase(CustomerRepository repository) {

		return args -> {
			log.info("Preloading " + repository.save(new Customer("Tom")));
			log.info("Preloading " + repository.save(new Customer("Dang")));
		};
	}
}