package com.codestates.preproject.comment.controller;

import com.codestates.preproject.comment.dto.CommentPatchDto;
import com.codestates.preproject.comment.dto.CommentPostDto;
import com.codestates.preproject.comment.mapper.CommentMapper;
import com.codestates.preproject.comment.service.CommentService;
import com.codestates.preproject.comment.dto.SingleResponseDto;
import com.codestates.preproject.comment.entity.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    //에러 방지를 위해 일단 주석처리 했습니다.
    //private final ArticleService articleService;
    //private final UserService userService;

    public CommentController(CommentService commentService, CommentMapper commentMapper) {
        this.commentService = commentService;
        this.commentMapper = commentMapper;
    }

    // 댓글 생성
    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentPostDto commentPostDto) {

        Comment comment = commentMapper.commentPostToComment(commentPostDto);
//        long commentId = comment.getCommentId();

        Comment createdComment = commentService.createComment(comment);

        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponse(createdComment)),
                HttpStatus.CREATED);

    }

    // 댓글 수정
    @PatchMapping("/comment/{comment-id}")
    public ResponseEntity patchComment(
            @PathVariable("comment-id") @Positive long commentId,
            @Valid @RequestBody CommentPatchDto commentPatchDto) {

        commentPatchDto.setCommentId(commentId);

        Comment comment = commentService.updateComment(commentMapper.commentPatchToComment(commentPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),
                HttpStatus.OK);
    }


}
