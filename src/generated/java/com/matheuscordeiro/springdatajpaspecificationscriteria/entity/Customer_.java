package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDate;

@StaticMetamodel(Customer.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Customer_ {

	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer#birthday
	 **/
	public static volatile SingularAttribute<Customer, LocalDate> birthday;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer#createdAt
	 **/
	public static volatile SingularAttribute<Customer, LocalDate> createdAt;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer#firstname
	 **/
	public static volatile SingularAttribute<Customer, String> firstname;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer#id
	 **/
	public static volatile SingularAttribute<Customer, Long> id;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer
	 **/
	public static volatile EntityType<Customer> class_;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Customer#lastname
	 **/
	public static volatile SingularAttribute<Customer, String> lastname;

	public static final String BIRTHDAY = "birthday";
	public static final String CREATED_AT = "createdAt";
	public static final String FIRSTNAME = "firstname";
	public static final String ID = "id";
	public static final String LASTNAME = "lastname";

}

