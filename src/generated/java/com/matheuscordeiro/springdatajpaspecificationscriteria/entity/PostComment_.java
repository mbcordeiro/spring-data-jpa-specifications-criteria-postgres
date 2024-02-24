package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.EntityType;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.LocalDateTime;

@StaticMetamodel(PostComment.class)
@Generated("org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
public abstract class PostComment_ {

	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#post
	 **/
	public static volatile SingularAttribute<PostComment, Post> post;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#review
	 **/
	public static volatile SingularAttribute<PostComment, String> review;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#votes
	 **/
	public static volatile SingularAttribute<PostComment, Integer> votes;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#id
	 **/
	public static volatile SingularAttribute<PostComment, Long> id;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment
	 **/
	public static volatile EntityType<PostComment> class_;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#createdOn
	 **/
	public static volatile SingularAttribute<PostComment, LocalDateTime> createdOn;
	
	/**
	 * @see com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment#status
	 **/
	public static volatile SingularAttribute<PostComment, String> status;

	public static final String POST = "post";
	public static final String REVIEW = "review";
	public static final String VOTES = "votes";
	public static final String ID = "id";
	public static final String CREATED_ON = "createdOn";
	public static final String STATUS = "status";

}

