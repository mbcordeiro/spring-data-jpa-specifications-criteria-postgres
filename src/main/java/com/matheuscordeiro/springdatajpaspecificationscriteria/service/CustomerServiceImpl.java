package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer;
import com.matheuscordeiro.springdatajpaspecificationscriteria.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public void save(CustomerDto customerDto) {
        final var customer = new Customer(customerDto.firstname(), customerDto.lastname(), customerDto.birthday());
        customerRepository.save(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerDto findById(Long id) {
        final var customer = customerRepository.findById(id).orElseThrow();
        return new CustomerDto(customer.getFirstname(), customer.getLastname(), customer.getBirthday());
    }

    @Override
    public boolean customerHasBirthday() {
        return customerRepository.exists(CustomerSpecifications.customerHasBirthday());
    }

    @Override
    public boolean isLongTermCustomer() {
        return customerRepository.exists(CustomerSpecifications.isLongTermCustomer());
    }
}
