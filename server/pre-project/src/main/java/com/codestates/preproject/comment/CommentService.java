package com.codestates.preproject.comment;

import com.codestates.preproject.article.ArticleRepository;
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

    @Autowired
    private ArticleRepository articleRepository;

}
