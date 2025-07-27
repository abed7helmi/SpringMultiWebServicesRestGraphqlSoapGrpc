package com.example.customerdataservice;

import com.example.customerdataservice.entities.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerDataServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerDataServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder().name("Hassen").email("hassen@yahoo.fr").build());
            customerRepository.save(Customer.builder().name("Helmi").email("Helmi@yahoo.fr").build());
            customerRepository.save(Customer.builder().name("Med").email("med@yahoo.fr").build());
        };

    }

}
