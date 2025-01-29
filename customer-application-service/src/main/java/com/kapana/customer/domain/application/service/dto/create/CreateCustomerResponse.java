package com.kapana.customer.domain.application.service.dto.create;

import lombok.NonNull;

import java.util.UUID;


public record CreateCustomerResponse(@NonNull UUID customerId, @NonNull String message) {}
