package com.kapana.customerdomaincore.event;

import com.kapana.commondomain.event.DomainEvent;
import com.kapana.customerdomaincore.entity.Customer;

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
