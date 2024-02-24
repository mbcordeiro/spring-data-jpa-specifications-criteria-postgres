package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(Account.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Account_ {

	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Account#expiryDate
	 **/
	public static volatile SingularAttribute<Account, LocalDateTime> expiryDate;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Account#id
	 **/
	public static volatile SingularAttribute<Account, Long> id;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Account
	 **/
	public static volatile EntityType<Account> class_;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Account#customer
	 **/
	public static volatile SingularAttribute<Account, Customer> customer;

	public static final String EXPIRY_DATE = "expiryDate";
	public static final String ID = "id";
	public static final String CUSTOMER = "customer";

}

