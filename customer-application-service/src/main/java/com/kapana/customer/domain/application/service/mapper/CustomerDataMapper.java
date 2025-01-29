package com.kapana.customer.domain.application.service.mapper;

import com.kapana.common.domain.valueObject.CustomerId;
import com.kapana.customer.domain.application.service.dto.create.CreateCustomerCommand;
import com.kapana.customer.domain.application.service.dto.create.CreateCustomerResponse;
import com.kapana.customer.domain.core.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerDataMapper {


    public Customer createCustomerCommandToCustomer(CreateCustomerCommand createCustomerCommand) {

        return new Customer(
                new CustomerId(createCustomerCommand.getCustomerId()),
                createCustomerCommand.getUsername(),
                createCustomerCommand.getEmail(),
                createCustomerCommand.getPhone(),
                createCustomerCommand.getFirstName(),
                createCustomerCommand.getLastName()
        );
    }

    public CreateCustomerResponse customerToCreateCustomerResponse(Customer customer, String message) {
        return  new CreateCustomerResponse(
                customer.getId().getValue(),
                message
        );
    }




}
