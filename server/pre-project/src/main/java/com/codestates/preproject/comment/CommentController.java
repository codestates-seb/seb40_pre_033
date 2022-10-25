package com.codestates.preproject.comment;

import com.codestates.preproject.article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    @Autowired
    private final CommentService commentService;

    @Autowired
    private final ArticleService articleService;


    // 댓글 생성

    // 댓글 수정

    // 댓글 삭제

}
