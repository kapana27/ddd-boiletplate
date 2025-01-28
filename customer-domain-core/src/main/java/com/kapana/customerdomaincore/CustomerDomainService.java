package com.kapana.customerdomaincore;

import com.kapana.customerdomaincore.entity.Customer;
import com.kapana.customerdomaincore.event.CustomerCreatedEvent;

public interface CustomerDomainService {
    CustomerCreatedEvent validateAndInitiateCustomer(Customer customer);
}
