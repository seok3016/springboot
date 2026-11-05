package me.jhseok.springdeveloper.service;

import me.jhseok.springdeveloper.dao.Article;
import me.jhseok.springdeveloper.dto.ArticleCreationRequest;
import me.jhseok.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    private final BlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    public Article save(ArticleCreationRequest articleCreationRequest) {
        return blogRepository.save(articleCreationRequest.toEntity());
    }
}