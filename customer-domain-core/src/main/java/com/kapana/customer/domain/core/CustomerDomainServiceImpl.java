package com.kapana.customer.domain.core;

import com.kapana.customer.domain.core.entity.Customer;
import com.kapana.customer.domain.core.event.CustomerCreatedEvent;
import lombok.extern.slf4j.Slf4j;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Slf4j
public class CustomerDomainServiceImpl implements CustomerDomainService {

    @Override
    public CustomerCreatedEvent validateAndInitiateCustomer(Customer customer) {

        log.info("Customer with id: {} is initiated", customer.getId().getValue());

        return new CustomerCreatedEvent(customer, ZonedDateTime.now(ZoneId.of("UTC")));
    }
}
