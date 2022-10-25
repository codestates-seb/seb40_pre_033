package com.codestates.preproject.comment;

import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

//    @ManyToOne  //답변이 n 글이 1
//    @JoinColumn(name = "article_id")
//    private Article article;

    @Column
    private String content;

    @Column
    private String userName;

    private String createDate;

    private int vote;
}
