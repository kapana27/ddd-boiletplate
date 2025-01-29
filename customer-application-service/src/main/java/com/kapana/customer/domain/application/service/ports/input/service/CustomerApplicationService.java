package com.kapana.customer.domain.application.service.ports.input.service;

import com.kapana.customer.domain.application.service.dto.create.CreateCustomerCommand;
import com.kapana.customer.domain.application.service.dto.create.CreateCustomerResponse;
import com.kapana.customer.domain.application.service.dto.list.ListCustomerCommand;
import com.kapana.customer.domain.application.service.dto.list.ListCustomerResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface CustomerApplicationService {

    CreateCustomerResponse createCustomer(@Valid CreateCustomerCommand createCustomerCommand);

    ListCustomerResponse getCustomers(@Valid ListCustomerCommand listCustomerCommand);
}
