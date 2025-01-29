package com.kapana.customer.domain.application.service.dto.list;

import com.kapana.customer.domain.core.entity.Customer;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListCustomerResponse {
    Integer count;
    List<Customer> customers;
}
