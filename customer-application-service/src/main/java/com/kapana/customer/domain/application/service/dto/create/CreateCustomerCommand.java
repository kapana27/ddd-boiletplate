package com.kapana.customer.domain.application.service.dto.create;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateCustomerCommand {

    @NonNull
    private final UUID customerId;
    @NonNull
    private final String username;
    @NonNull
    private final String email;
    @NonNull
    private final String phone;
    @NotNull
    private final String firstName;
    @NotNull
    private final String lastName;

}
