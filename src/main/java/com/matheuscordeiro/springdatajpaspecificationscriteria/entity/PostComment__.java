package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;
import java.time.LocalDate;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PostComment.class)
public abstract class PostComment__ {
    public static volatile SingularAttribute<PostComment, Post> post;
    public static volatile SingularAttribute<PostComment, String> review;
    public static volatile SingularAttribute<PostComment, Long> id;
    public static volatile SingularAttribute<PostComment, String> status;
    public static volatile SingularAttribute<PostComment, Integer> votes;
    public static volatile SingularAttribute<PostComment, LocalDate> cretedOn;


    public static final String POST = "post";
    public static final String REVIEW = "review";
    public static final String ID = "id";
    public static final String STATUS = "status";
    public static final String VOTES = "votes";
    public static final String CREATED_ON = "createdOn";
}