package com.example.customerdataservice.config;

import com.example.customerdataservice.web.CustomerSoapService;
import lombok.AllArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CxfConfig {

    private Bus bus ;
    private CustomerSoapService customerSoapService ;

    @Bean
    public EndpointImpl getEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, customerSoapService);
        endpoint.publish("/CustomerService");
        return endpoint ;
    }
}
