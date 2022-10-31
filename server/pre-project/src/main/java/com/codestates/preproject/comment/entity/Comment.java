package com.codestates.preproject.comment.entity;

import com.codestates.preproject.article.Article;
import com.codestates.preproject.audit.BaseTime;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "COMMENT")
@Table(name = "COMMETS")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseTime {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

//    @ManyToOne
//    @JoinColumn(name = "article_id")
//    private Article articleId;

    @Column(name = "user_name",  nullable = false)
    private String username;

    @Column(name = "comment_content",  nullable = false)
    private String content;

    @Builder
    public Comment(String username, String content) {
        this.username = username;
        this.content = content;
    }

    //TODO  PV와 NV는 추후 추가예정

    // TODO 대댓은 시간이 가능하다면 추가 예정
}