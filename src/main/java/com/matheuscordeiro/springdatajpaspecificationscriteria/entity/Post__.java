package com.matheuscordeiro.springdatajpaspecificationscriteria.entity;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Post.class)
public abstract class Post__ {
    public static volatile ListAttribute<Post, PostComment> comments;
    public static volatile SingularAttribute<Post, Long> id;
    public static volatile SingularAttribute<Post, String> title;


    public static final String COMMENTS = "comments";
    public static final String ID = "id";
    public static final String TITLE = "title";
}
