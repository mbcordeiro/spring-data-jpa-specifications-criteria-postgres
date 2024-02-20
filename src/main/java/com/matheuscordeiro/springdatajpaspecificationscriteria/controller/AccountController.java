package com.matheuscordeiro.springdatajpaspecificationscriteria.controller;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.AccountDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final AccountDto accountDto) {
        accountService.save(accountDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<AccountDto>> getByCustomer(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.findByCustomer(id));
    }
}
