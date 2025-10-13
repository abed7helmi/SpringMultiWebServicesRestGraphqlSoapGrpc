package com.example.customerdataservice.mapper;


import com.example.customerdataservice.dto.CustomerRequest;
import com.example.customerdataservice.entities.Customer;
import com.example.customerdataservice.stub.CustomerServiceOuterClass;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public Customer from(CustomerRequest customerRequest){
        //Customer customer = new Customer();
        //customer.setEmail(customerRequest.email());
        //customer.setName(customerRequest.name());
         Customer c = modelMapper.map(customerRequest, Customer.class);
        return c;
    }


    public CustomerServiceOuterClass.Customer fromCustomer(Customer customer){
        // on neccessite utiliser un builder
        return modelMapper.map(customer, CustomerServiceOuterClass.Customer.Builder.class).build();
    }

    public Customer fromGrpcCustomerRequest(CustomerServiceOuterClass.CustomerRequest customerRequest){
        return modelMapper.map(customerRequest, Customer.class);
    }

}
