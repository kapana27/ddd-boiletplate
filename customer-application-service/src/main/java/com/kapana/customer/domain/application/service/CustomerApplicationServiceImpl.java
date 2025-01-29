package com.kapana.customer.domain.application.service;

import com.kapana.customer.domain.application.service.dto.create.CreateCustomerCommand;
import com.kapana.customer.domain.application.service.dto.create.CreateCustomerResponse;
import com.kapana.customer.domain.application.service.dto.list.ListCustomerCommand;
import com.kapana.customer.domain.application.service.dto.list.ListCustomerResponse;
import com.kapana.customer.domain.application.service.mapper.CustomerDataMapper;
import com.kapana.customer.domain.application.service.ports.input.service.CustomerApplicationService;
import com.kapana.customer.domain.core.CustomerDomainService;
import com.kapana.customer.domain.core.entity.Customer;
import com.kapana.customer.domain.core.event.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Slf4j
@Validated
public class CustomerApplicationServiceImpl implements CustomerApplicationService {

    private final CustomerDataMapper customerDataMapper;
    private  final CustomerCreateCommandHandler customerCreateCommandHandler;
    private  final CustomerListCommandHandler customerListCommandHandler;

    public CustomerApplicationServiceImpl(CustomerDataMapper customerDataMapper, CustomerDomainService customerDomainService, CustomerCreateCommandHandler customerCreateCommandHandler, CustomerListCommandHandler customerListCommandHandler) {
        this.customerDataMapper = customerDataMapper;
        this.customerCreateCommandHandler = customerCreateCommandHandler;
        this.customerListCommandHandler = customerListCommandHandler;
    }


    @Override
    public CreateCustomerResponse createCustomer(CreateCustomerCommand createCustomerCommand) {
        CustomerCreatedEvent customerCreatedEvent = customerCreateCommandHandler.createCustomer(createCustomerCommand);

        return customerDataMapper.customerToCreateCustomerResponse(customerCreatedEvent.getCustomer(),
                "Customer saved successfully!");
    }

    @Override
    public ListCustomerResponse getCustomers(ListCustomerCommand listCustomerCommand) {

        List<Customer>  customers = customerListCommandHandler.getCustomers(listCustomerCommand);

        if (customers != null && !customers.isEmpty()) {
            return new ListCustomerResponse(customers.size(), customers);
        }

        return new ListCustomerResponse(0, List.of());
    }


}
