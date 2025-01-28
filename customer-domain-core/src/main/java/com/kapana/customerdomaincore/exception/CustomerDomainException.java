package com.kapana.customerdomaincore.exception;

public class CustomerDomainException extends RuntimeException {
    public CustomerDomainException(String message) {
        super(message);
    }
}
