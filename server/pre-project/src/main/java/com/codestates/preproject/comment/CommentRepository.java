package com.codestates.preproject.comment;

import com.codestates.preproject.comment.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository extends JpaRepository<CommentEntity,Long> {

//    특정 게시글의 모든 댓글
//    @Query(value =
//            "SELECT * " +
//                    "FROM comment " +
//                    "WHERE article_id = :articleId",
//            nativeQuery = true)

    List<CommentEntity> findByArticleId(@Param("articleId") Long articleId);

    // 특정 닉네임의 모든 댓글
    List<CommentEntity> findByUserName(String userName);
}
