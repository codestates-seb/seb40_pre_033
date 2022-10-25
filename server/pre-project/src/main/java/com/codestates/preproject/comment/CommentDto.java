package com.codestates.preproject.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CommentDto {
    private Long commentId;
    //private Long articleId;
    //private String email;
    private String userName;

    public static CommentDto createCommentDto(CommentEntity comment) {
        return new CommentDto(
                comment.getCommentId(),
                //comment.getArticleId(),
                comment.getUserName()
        );
    }
}
