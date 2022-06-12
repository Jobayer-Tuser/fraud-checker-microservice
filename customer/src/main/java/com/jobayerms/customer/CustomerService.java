package com.jobayerms.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;
    public void registerCustomer(CustomerRegistrationRequest request) throws Exception {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        customerRepository.saveAndFlush(customer);

        //check if fraud
        FraudCheckResponse fraudCheckResponse =  restTemplate.getForObject("http://localhost:9091/api/v1/fraud-check/customer/{customerId}", FraudCheckResponse.class, customer.getId());
        if(fraudCheckResponse.getIsFraudster()){
            throw new Exception("Fraud");
        }
    }
}
