package com.matheuscordeiro.springdatajpaspecificationscriteria.controller;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.CustomerDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody final CustomerDto customerDto) {
        customerService.save(customerDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getByCustomer(@PathVariable final Long id) {
        return ResponseEntity.ok(customerService.findById(id));
    }
}
