package com.kapana.customerapplicationservice.ports.input.service;

import com.kapana.customerapplicationservice.create.CreateCustomerCommand;
import com.kapana.customerapplicationservice.create.CreateCustomerResponse;
import jakarta.validation.Valid;

public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);
}
