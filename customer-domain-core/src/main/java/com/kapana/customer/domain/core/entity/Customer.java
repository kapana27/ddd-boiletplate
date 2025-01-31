package com.kapana.customer.domain.core.entity;

import com.kapana.common.domain.entity.AggregateRoot;
import com.kapana.common.domain.valueObject.CustomerId;
import lombok.Getter;

@Getter
public class Customer extends AggregateRoot<CustomerId> {

    private final String username;
    private final String email;
    private final String phone;
    private final String fistName;
    private final String lastName;


    public Customer(CustomerId customerId,String username, String email, String phone, String fistName, String lastName) {
        this.setId(customerId);
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.fistName = fistName;
        this.lastName = lastName;
    }
}