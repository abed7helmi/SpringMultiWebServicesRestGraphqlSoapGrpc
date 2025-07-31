package com.example.customerdataservice.web;

import com.example.customerdataservice.entities.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> allCustomers() {
        return customerRepository.findAll();
    }
}
