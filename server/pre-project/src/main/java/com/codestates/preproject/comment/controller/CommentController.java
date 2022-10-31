package com.codestates.preproject.comment.controller;

import com.codestates.preproject.comment.dto.CommentPatchDto;
import com.codestates.preproject.comment.dto.CommentPostDto;
import com.codestates.preproject.comment.mapper.CommentMapper;
import com.codestates.preproject.comment.service.CommentService;
import com.codestates.preproject.response.SingleResponseDto;
import com.codestates.preproject.comment.entity.Comment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
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

    // 답변 조회
    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(
            @PathVariable("comment-id") @Positive long commentId) {

        Comment comment = commentService.findComment(commentId);

        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),
                HttpStatus.OK
        );
    }


    // 답변 생성
    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentPostDto commentPostDto) {

        Comment comment = commentMapper.commentPostToComment(commentPostDto);
//        long commentId = comment.getCommentId();

        Comment createdComment = commentService.createComment(comment);

        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponse(createdComment)),
                HttpStatus.CREATED);

    }

    // 답변 수정
    @PatchMapping("/{comment-id}")
    public ResponseEntity patchComment(
            @PathVariable("comment-id") @Positive long commentId,
            @Valid @RequestBody CommentPatchDto commentPatchDto) {

        commentPatchDto.setCommentId(commentId);

        Comment comment = commentService.updateComment(commentMapper.commentPatchToComment(commentPatchDto));

        return new ResponseEntity<>(
                new SingleResponseDto<>(commentMapper.commentToCommentResponse(comment)),
                HttpStatus.OK);
    }

    // 답변 삭제
    @DeleteMapping("/{comment-id}")
    public ResponseEntity deleteComment(
            @PathVariable("comment-id") @Positive long commentId) {

        commentService.deleteComment(commentId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
