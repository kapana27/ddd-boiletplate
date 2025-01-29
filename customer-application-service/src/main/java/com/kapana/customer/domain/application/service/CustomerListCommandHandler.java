package com.kapana.customer.domain.application.service;

import com.kapana.customer.dataaccess.repository.CustomerRepository;
import com.kapana.customer.domain.application.service.dto.list.ListCustomerCommand;
import com.kapana.customer.domain.application.service.mapper.CustomerDataMapper;
import com.kapana.customer.domain.core.CustomerDomainService;
import com.kapana.customer.domain.core.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CustomerListCommandHandler {

    private final CustomerRepository customerRepository;

    public CustomerListCommandHandler(CustomerDataMapper customerDataMapper, CustomerDomainService customerDomainService, CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(ListCustomerCommand listCustomerCommand) {
        log.info("Getting all customers");
        return customerRepository.findAll();
    }

}
