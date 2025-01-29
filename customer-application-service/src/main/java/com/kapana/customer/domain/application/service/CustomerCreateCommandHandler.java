package com.kapana.customer.domain.application.service;


import com.kapana.customer.domain.application.service.dto.create.CreateCustomerCommand;
import com.kapana.customer.domain.application.service.mapper.CustomerDataMapper;
import com.kapana.customer.dataaccess.repository.CustomerRepository;
import com.kapana.customer.domain.core.CustomerDomainService;
import com.kapana.customer.domain.core.entity.Customer;
import com.kapana.customer.domain.core.event.CustomerCreatedEvent;
import com.kapana.customer.domain.core.exception.CustomerDomainException;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerCreateCommandHandler {

     private final CustomerDataMapper customerDataMapper;
     private final CustomerDomainService customerDomainService;
     private final CustomerRepository customerRepository;
    public CustomerCreateCommandHandler(CustomerDataMapper customerDataMapper, CustomerDomainService customerDomainService, CustomerRepository customerRepository) {
        this.customerDataMapper = customerDataMapper;
        this.customerDomainService = customerDomainService;
        this.customerRepository = customerRepository;
    }


    @Transactional
    public CustomerCreatedEvent createCustomer(CreateCustomerCommand createCustomerCommand){

        Customer customer = customerDataMapper.createCustomerCommandToCustomer(createCustomerCommand);

        CustomerCreatedEvent customerCreatedEvent = customerDomainService.validateAndInitiateCustomer(customer);

        Customer savedCustomer = customerRepository.save(customer);

        if (savedCustomer == null) {
            log.error("Could not save customer with id: {}", createCustomerCommand.getCustomerId());
            throw new CustomerDomainException("Could not save customer with id " +
                    createCustomerCommand.getCustomerId());
        }
        log.info("Customer saved successfully with id: {}", savedCustomer.getId().getValue());

        return customerCreatedEvent;
     }




}
