package me.jhseok.springdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.jhseok.springdeveloper.dao.Article;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleCreationRequest {
    private String title;
    private String content;
    public Article toEntity(){
        return Article.builder().title(this.title).content(this.content).build();
    }
}
