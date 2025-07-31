package com.example.customerdataservice.mapper;


import com.example.customerdataservice.dto.CustomerRequest;
import com.example.customerdataservice.entities.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer from(CustomerRequest customerRequest){
        Customer customer = new Customer();
        customer.setEmail(customerRequest.email());
        customer.setName(customerRequest.name());
        return customer;
    }
}
