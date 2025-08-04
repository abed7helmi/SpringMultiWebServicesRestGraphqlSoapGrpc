package com.example.customerdataservice.web;

import com.example.customerdataservice.dto.CustomerRequest;
import com.example.customerdataservice.entities.Customer;
import com.example.customerdataservice.mapper.CustomerMapper;
import com.example.customerdataservice.repository.CustomerRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(serviceName = "CustomerWebService") // a partir java 9 c plus javax (  jakarta remplace javaX )
public class CustomerSoapService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;


    @WebMethod
    public List<Customer> cusomerList(){
        return customerRepository.findAll();
    }


    @WebMethod
    public Customer getCustomerById(@WebParam Long id){
        return customerRepository.findById(id).get();
    }

    @WebMethod
    public Customer saveCustomer(@WebParam CustomerRequest customer){
        return customerRepository.save(customerMapper.from(customer));
    }
}
