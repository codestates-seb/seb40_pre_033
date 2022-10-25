package com.codestates.preproject.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    @Autowired
    private final CommentService commentService;

    // 댓글 목록 조회는 게시글 api와 함께 들어간다
    // 리다이렉트
    @RequestMapping("/")
    public String root() {
        return "redirect:/comment";
    }

    // 댓글 생성
    @PostMapping("/comment/{comment-id}")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId, @RequestBody CommentDto dto) {

        // 서비스에 위임
        CommentDto createDto = commentService.create(articleId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createDto);
    }



    // 댓글 수정
    @PatchMapping("/comment/{comment-id}")
    public String commentUpdate(@RequestBody String content, @PathVariable Integer id) {
        this.commentService.update(id, content);

        return "redirect:/comment";
    }

    // 댓글 삭제
    @DeleteMapping("/comment/{comment-id}")
    public String todoDelete(@PathVariable Integer id) {
        this.commentService.delete(id);

        return "redirect:/comment";
    }
}
