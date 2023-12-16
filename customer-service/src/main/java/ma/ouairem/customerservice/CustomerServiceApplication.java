package ma.ouairem.customerservice;

import ma.ouairem.customerservice.entities.Customer;
import ma.ouairem.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
		return args -> {
			Customer customer1 = Customer.builder()
					.firstName("Imad")
					.lastName("Ouairem")
					.email("imad.o@gmail.com")
					.build();
			customerRepository.save(customer1);

			Customer customer2 = Customer.builder()
					.firstName("Karim")
					.lastName("Essaid")
					.email("Karimo@gmail.com")
					.build();
			customerRepository.save(customer2);
		};
	}

}
