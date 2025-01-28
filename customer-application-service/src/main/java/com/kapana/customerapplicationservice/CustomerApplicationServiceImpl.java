package com.kapana.customerapplicationservice;

import com.kapana.customerapplicationservice.create.CreateCustomerCommand;
import com.kapana.customerapplicationservice.create.CreateCustomerResponse;
import com.kapana.customerapplicationservice.mapper.CustomerDataMapper;
import com.kapana.customerapplicationservice.ports.input.service.CustomerApplicationService;
import com.kapana.customerdomaincore.CustomerDomainService;
import com.kapana.customerdomaincore.entity.Customer;
import com.kapana.customerdomaincore.event.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Slf4j
@Validated
public class CustomerApplicationServiceImpl implements CustomerApplicationService {

    private final CustomerDataMapper customerDataMapper;
    private final CustomerDomainService customerDomainService;
    private  final CustomerCreateCommandHandler customerCreateCommandHandler;

    public CustomerApplicationServiceImpl(CustomerDataMapper customerDataMapper, CustomerDomainService customerDomainService, CustomerCreateCommandHandler customerCreateCommandHandler) {
        this.customerDataMapper = customerDataMapper;
        this.customerDomainService = customerDomainService;
        this.customerCreateCommandHandler = customerCreateCommandHandler;
    }


    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand createCustomerCommand) {
        CustomerCreatedEvent customerCreatedEvent = customerCreateCommandHandler.createCustomer(createCustomerCommand);

        return null;
    }
}
