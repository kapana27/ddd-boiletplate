package com.kapana.customerapplicationservice;


import com.kapana.customerapplicationservice.create.CreateCustomerCommand;
import com.kapana.customerapplicationservice.mapper.CustomerDataMapper;
import com.kapana.customerdataaccess.repository.CustomerRepository;
import com.kapana.customerdomaincore.CustomerDomainService;
import com.kapana.customerdomaincore.entity.Customer;
import com.kapana.customerdomaincore.event.CustomerCreatedEvent;
import com.kapana.customerdomaincore.exception.CustomerDomainException;
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
