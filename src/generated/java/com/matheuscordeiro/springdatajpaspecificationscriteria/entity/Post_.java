package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Post.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class Post_ {

	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post#author
	 **/
	public static volatile SingularAttribute<Post, String> author;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post#id
	 **/
	public static volatile SingularAttribute<Post, Long> id;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post#title
	 **/
	public static volatile SingularAttribute<Post, String> title;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post
	 **/
	public static volatile EntityType<Post> class_;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post#slug
	 **/
	public static volatile SingularAttribute<Post, String> slug;

	public static final String AUTHOR = "author";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String SLUG = "slug";

}

