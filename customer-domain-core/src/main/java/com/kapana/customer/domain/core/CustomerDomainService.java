package com.kapana.customer.domain.core;

import com.kapana.customer.domain.core.entity.Customer;
import com.kapana.customer.domain.core.event.CustomerCreatedEvent;

public interface CustomerDomainService {
    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);
}
