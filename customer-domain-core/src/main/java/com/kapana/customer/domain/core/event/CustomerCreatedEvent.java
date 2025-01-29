package com.kapana.customer.domain.core.event;

import com.kapana.common.domain.event.DomainEvent;
import com.kapana.customer.domain.core.entity.Customer;

import java.time.ZonedDateTime;

public class CustomerCreatedEvent implements DomainEvent<Customer> {

    private  final Customer customer;

    private final ZonedDateTime createdAt;


    public CustomerCreatedEvent(Customer customer, ZonedDateTime createdAt) {
        this.customer = customer;
        this.createdAt = createdAt;
    }

    public Customer getCustomer() {
        return customer;
    }
}
