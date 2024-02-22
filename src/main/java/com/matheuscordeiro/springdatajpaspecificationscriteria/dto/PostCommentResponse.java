package com.matheuscordeiro.springdatajpaspecificationscriteria.dto;

public record PostCommentResponse(String review, String status, int votes, PostDto postDto) {
}
