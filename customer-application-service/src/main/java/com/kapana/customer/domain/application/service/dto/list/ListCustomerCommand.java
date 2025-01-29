package com.kapana.customer.domain.application.service.dto.list;

import lombok.*;
import org.springframework.data.domain.Sort;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ListCustomerCommand {

    @NonNull
    private Integer page=0;

    @NonNull
    private Integer size=20;

    private String sortBy = "id"; // Default sorting field

    private Sort.Direction direction = Sort.Direction.ASC; // Default sorting direction
}
