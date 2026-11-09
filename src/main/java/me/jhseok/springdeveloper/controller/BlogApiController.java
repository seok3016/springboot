package me.jhseok.springdeveloper.controller;

import lombok.RequiredArgsConstructor;
import me.jhseok.springdeveloper.dao.Article;
import me.jhseok.springdeveloper.dto.ArticleCreationRequest;
import me.jhseok.springdeveloper.dto.ArticleResponse;
import me.jhseok.springdeveloper.service.BlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BlogApiController {
    private final BlogService blogService;

    @PostMapping("/api/articles")
    public ResponseEntity<Article> addArticle(@RequestBody ArticleCreationRequest request) {
        Article savedArticle = blogService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedArticle);
    }

    @GetMapping("/api/articles")
    public ResponseEntity<List<ArticleResponse>> findAllArticles() {
        List<ArticleResponse> articles = blogService.findAll()
                .stream()
                .map(ArticleResponse::new)
                .toList();
        return ResponseEntity.ok()
                .body(articles);
    }

    @GetMapping("/api/articles/{id}")
    public ResponseEntity<ArticleResponse> getArticleByID(@PathVariable Long id){
        Article article = blogService.findbyid(id);
        return  ResponseEntity.ok(new ArticleResponse(article));
    }
}