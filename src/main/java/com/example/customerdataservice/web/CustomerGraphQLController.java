package com.example.customerdataservice.web;

import com.example.customerdataservice.entities.Customer;
import com.example.customerdataservice.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
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

    @QueryMapping
    public Customer customerById(@Argument Long id) {
        Customer customer=  customerRepository.findById(id).orElse(null);
        if(customer == null) {
            throw  new RuntimeException(String.format("Customer with id %s not found", id));
        }else {
            return customer;
        }

    }

    @MutationMapping
    public Customer saveCustomer(@Argument Customer customer) {
        return customerRepository.save(customer);
    }
}
