package com.matheuscordeiro.springdatajpaspecificationscriteria.repository;

import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.Post;
import com.matheuscordeiro.springdatajpaspecificationscriteria.entity.PostComment;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PostCommentRepository extends JpaRepository<PostComment, Long>,
        JpaSpecificationExecutor<PostComment> {
    interface Specs {
        static Specification<PostComment> byPost(Post post) {
            return (root, query, builder) ->
                    builder.equal(root.get("post"), post);
        }

        static Specification<PostComment> byStatus(String status) {
            return (root, query, builder) ->
                    builder.equal(root.get("status"), status);
        }

        static Specification<PostComment> byReviewLike(String reviewPattern) {
            return (root, query, builder) ->
                    builder.like(root.get("review"), reviewPattern);
        }

        static Specification<PostComment> byVotesGreaterThanEqual(int votes) {
            return (root, query, builder) ->
                    builder.greaterThanOrEqualTo(root.get("votes"), votes);
        }

        static Specification<PostComment> orderByCreatedOn(
                Specification<PostComment> spec) {
            return (root, query, builder) -> {
                query.orderBy(builder.asc(root.get("createdOn")));
                return spec.toPredicate(root, query, builder);
            };
        }
    }
}
