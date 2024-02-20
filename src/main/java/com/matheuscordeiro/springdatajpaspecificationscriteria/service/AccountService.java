package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.AccountDto;

import java.util.List;

public interface AccountService {
    void save(AccountDto accountDto);

    List<AccountDto> findByCustomer(Long id);
}
