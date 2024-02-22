package com.matheuscordeiro.springdatajpaspecificationscriteria.controller;

import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.PostCommentDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.PostCommentResponse;
import com.matheuscordeiro.springdatajpaspecificationscriteria.dto.PostDto;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment;
import com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository;
import com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository.Specs.byStatus;
import static com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository.Specs.orderByCreatedOn;
import static com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository.Specs.byPost;
import static com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository.Specs.byReviewLike;
import static com.matheuscordeiro.springdatajpaspecificationscriteria.repository.PostCommentRepository.Specs.byVotesGreaterThanEqual;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRepository postRepository;

    private final PostCommentRepository postCommentRepository;

    public PostController(PostRepository postRepository, PostCommentRepository postCommentRepository) {
        this.postRepository = postRepository;
        this.postCommentRepository = postCommentRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody final PostDto postDto) {
        postRepository.save(new Post(postDto.tittle(), postDto.slug(), postDto.author()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/comments")
    public ResponseEntity<Void> create(@RequestBody final PostCommentDto postCommentDto) {
        final var post = postRepository.findById(postCommentDto.idPost());
        if (post.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        postCommentRepository.save(new PostComment(post.get(), postCommentDto.review(), postCommentDto.status(),
                postCommentDto.votes()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<PostCommentResponse>> spec(@PathVariable String status) {
        final var specification = byStatus(status);
        final var postComments = postCommentRepository.findAll(specification);
        final var response = postComments.stream().map(postComment ->
                new PostCommentResponse(postComment.getReview(), postComment.getStatus(), postComment.getVotes(),
                        new PostDto(postComment.getPost().getTitle(), postComment.getPost().getSlug(),
                                postComment.getPost().getTitle()))).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<PostCommentResponse>> order() {
        final var post = postRepository.findById(1L);
        final var byPost = byPost(post.get());
        final var specification = orderByCreatedOn(byPost);
        final var postComments = postCommentRepository.findAll(specification);
        final var response = postComments.stream().map(postComment ->
                new PostCommentResponse(postComment.getReview(), postComment.getStatus(), postComment.getVotes(),
                        new PostDto(postComment.getPost().getTitle(), postComment.getPost().getSlug(),
                                postComment.getPost().getTitle()))).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @PostMapping("/on")
    public ResponseEntity<List<PostCommentResponse>> on(@RequestBody PostCommentDto postCommentDto) {
        final var post = postRepository.findById(postCommentDto.idPost()).orElseThrow();
        final var specification = orderByCreatedOn(
                byPost(post)
                        .and(byStatus(postCommentDto.status())
                                .and(byReviewLike(postCommentDto.review()))
                                .and(byVotesGreaterThanEqual(postCommentDto.votes())))
        );
        final var postComments = postCommentRepository.findAll(specification);
        final var response = postComments.stream().map(postComment ->
                new PostCommentResponse(postComment.getReview(), postComment.getStatus(), postComment.getVotes(),
                        new PostDto(postComment.getPost().getTitle(), postComment.getPost().getSlug(),
                                postComment.getPost().getTitle()))).collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
