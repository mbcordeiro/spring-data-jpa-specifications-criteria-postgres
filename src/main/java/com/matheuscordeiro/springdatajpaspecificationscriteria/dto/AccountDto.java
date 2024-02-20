package com.matheuscordeiro.springdatajpaspecificationscriteria.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record AccountDto(Long idCustomer, CustomerDto customerDto) {
}
