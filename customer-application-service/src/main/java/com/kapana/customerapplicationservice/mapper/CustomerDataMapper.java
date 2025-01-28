package com.kapana.customerapplicationservice.mapper;

import com.kapana.commondomain.valueObject.CustomerId;
import com.kapana.customerapplicationservice.create.CreateCustomerCommand;
import com.kapana.customerapplicationservice.create.CreateCustomerResponse;
import com.kapana.customerdomaincore.entity.Customer;
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
}
