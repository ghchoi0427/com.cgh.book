package com.cgh.book.springboot.web.dto;

import com.cgh.book.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsResponseDto(Posts entity){
        this.id=id;
        this.title= entity.getTitle();
        this.content=entity.getContent();
        this.author=entity.getAuthor();
    }
}
