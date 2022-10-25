package com.codestates.preproject.comment;

import com.codestates.preproject.comment.CommentDto;
import com.codestates.preproject.comment.CommentEntity;
import com.codestates.preproject.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    @Autowired
    private final CommentRepository commentRepository;

//    @Autowired
//    private ArticleRepository articleRepository;

    public List<CommentDto> getList(Long articleId) {

        // 답변 목록 조회
        List<CommentEntity> comments = commentRepository.findByArticleId(articleId);

        // 엔티티 -> DTO 변환
        List<CommentDto> dtos = new ArrayList<CommentDto>();
        for (int i = 0; i < comments.size(); i++) {
            CommentEntity comment = comments.get(i);
            CommentDto dto = CommentDto.createCommentDto(comment);
            dtos.add(dto);
        }

        return dtos;
    }

    public List<CommentDto> comments(Long articleId) {
        return commentRepository.findByArticleId(articleId)
                .stream()
                .map(comment -> CommentDto.createCommentDto(comment))
                .collect(Collectors.toList());
    }

    // 답변 생성
    public void create(String content) {
        CommentEntity comment = new CommentEntity();

        comment.setContent(content);

        this.commentRepository.save(comment);
    }

    // 답변 수정
    @Transactional
    public void update(Integer id, String content) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 답변이 없습니다. id=" + id));

        comment.setContent(content);
        this.commentRepository.save(comment);
    }

    // 답변 삭제
    @Transactional
    public void delete(Integer id) {
        CommentEntity comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 답변이 없습니다. id = " + id));

        this.commentRepository.delete(comment);
    }
}
