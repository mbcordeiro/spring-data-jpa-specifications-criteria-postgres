package com.matheuscordeiro.springdatajpaspecificationscriteria.service;

import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CustomerSpecifications {
    public static Specification<Customer> customerHasBirthday() {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("birthday"), LocalDate.now());
            }
        };
    }

    public static Specification<Customer> isLongTermCustomer() {
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.lessThan(root.get("createdAt"), LocalDate.now().minusYears(2));
            }
        };
    }
}
