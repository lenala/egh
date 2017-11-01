package com.microsoft.egh;

import com.microsoft.egh.model.ClientFact;
import com.microsoft.egh.model.ClientFactRepository;
import com.microsoft.egh.model.ClientFactRepositoryDemo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EghApplication {
	private static final Logger log = LoggerFactory.getLogger(EghApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EghApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(ClientFactRepositoryDemo repository) {
		return (args) -> {
			// save a couple of customers
			repository.save(new ClientFact("Jack", "Bauer"));
			repository.save(new ClientFact("Chloe", "O'Brian"));
			repository.save(new ClientFact("Kim", "Bauer"));
			repository.save(new ClientFact("David", "Palmer"));
			repository.save(new ClientFact("Michelle", "Dessler"));

			// fetch all customers
			log.info("Found with findAll():");
			log.info("-------------------------------");
			for (ClientFact customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			ClientFact customer = repository.findOne(1L);
			log.info("Found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Found with findByLastNameStartsWithIgnoreCase('Bauer'):");
			log.info("--------------------------------------------");
			for (ClientFact bauer : repository
					.findByLastNameStartsWithIgnoreCase("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}

}
