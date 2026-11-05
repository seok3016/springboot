package me.jhseok.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.jhseok.springdeveloper.dao.Article;
import me.jhseok.springdeveloper.dto.ArticleCreationRequest;
import me.jhseok.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BlogApiController {

    private final BlogService blogService;

    public BlogApiController(BlogService blogService) {
        this.blogService = blogService;
    }
    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleCreationRequest articleCreationRequest){
        //서비스에게 블로그 글 등록을 의뢰.
        //성공했으면 ResponseEntity 객체를 반환
        Article savedArticle = blogService.save(articleCreationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArticle);
    }
}
