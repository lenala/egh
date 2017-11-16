package com.microsoft.egh;

import com.microsoft.egh.model.ClientDemographic;
import com.microsoft.egh.model.ClientDemographicRepository;
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
	public CommandLineRunner loadData(ClientDemographicRepository repository) {
		return (args) -> {
//			// save a couple of customers
//			repository.save(new ClientDemographic("Jack", "Bauer"));
//			repository.save(new ClientDemographic("Chloe", "O'Brian"));
//			repository.save(new ClientDemographic("Kim", "Bauer"));
//			repository.save(new ClientDemographic("David", "Palmer"));
//			repository.save(new ClientDemographic("Michelle", "Dessler"));
//
//			// fetch all customers
//			log.info("Found with findAll():");
//			log.info("-------------------------------");
//			for (ClientDemographic customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			ClientDemographic customer = repository.findOne(1);
//			log.info("Found with findOne(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Found with findByLastNameStartsWithIgnoreCase('Bauer'):");
//			log.info("--------------------------------------------");
//			for (ClientDemographic bauer : repository
//					.findByLastNameStartsWithIgnoreCase("Bauer")) {
//				log.info(bauer.toString());
//			}
			log.info("");
		};
	}

}
