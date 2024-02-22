package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.AccountDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Account;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @PersistenceContext
    EntityManager em;

    @Transactional
    @Override
    public void save(AccountDto accountDto) {
        final var customer = em.find(Customer.class, accountDto.idCustomer());
        final var account = new Account(customer, LocalDateTime.now().plusMonths(24));
        em.persist(account);
    }

    @Transactional(readOnly = true)
    @Override
    public List<AccountDto> findByCustomer(Long id) {
        final var customer = em.find(Customer.class, id);
        final var query = em.createQuery("select a from Account a where a.customer = ?1", Account.class);
        query.setParameter(1, customer);
        return query.getResultList().stream().map(account ->
                new AccountDto(account.getCustomer().getId(), new CustomerDto(account.getCustomer().getFirstname(),
                        account.getCustomer().getLastname(), customer.getBirthday()))
        ).collect(Collectors.toList());
    }
}
