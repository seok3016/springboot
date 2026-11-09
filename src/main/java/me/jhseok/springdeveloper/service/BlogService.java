package me.jhseok.springdeveloper.service;

import lombok.RequiredArgsConstructor;
import me.jhseok.springdeveloper.dao.Article;
import me.jhseok.springdeveloper.dto.ArticleCreationRequest;
import me.jhseok.springdeveloper.repository.BlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BlogService {
    private final BlogRepository blogRepository;

    public Article save(ArticleCreationRequest request) {
        return blogRepository.save(request.toEntity());
    }

    public List<Article> findAll(){
        return blogRepository.findAll();
    }
    public Article findbyid(long id){
        return blogRepository.findById(id).orElse(null);
    }
}