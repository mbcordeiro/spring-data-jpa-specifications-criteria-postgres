package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;

public interface CustomerService {
    void save(CustomerDto customerDto);

    CustomerDto findById(Long id);

    boolean customerHasBirthday();

    boolean isLongTermCustomer();
}
