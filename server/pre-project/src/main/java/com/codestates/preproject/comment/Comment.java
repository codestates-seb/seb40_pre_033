package com.codestates.preproject.comment;

import com.codestates.preproject.article.Article;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Column
    private String content;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "create_at")
    private String createDate;

    @Column
    private int vote;
}