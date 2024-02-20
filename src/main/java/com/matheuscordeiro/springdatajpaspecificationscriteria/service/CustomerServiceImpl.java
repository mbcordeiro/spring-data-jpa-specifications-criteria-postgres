package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    @Override
    public void save(CustomerDto customerDto) {
        final var customer = new Customer(customerDto.firstname(), customerDto.lastname());
        em.persist(customer);
    }

    @Transactional(readOnly = true)
    @Override
    public CustomerDto findById(Long id) {
        final Customer customer = em.find(Customer.class, id);
        return new CustomerDto(customer.getFirstname(), customer.getLastname());
    }
}
