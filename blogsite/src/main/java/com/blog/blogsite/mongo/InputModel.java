package com.blog.blogsite.mongo;

import org.springframework.data.mongodb.core.index.Indexed;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class InputModel {
    @NotBlank
    @Size(max = 100)
    private String author; 

    @NotBlank
    @Size(max=200)
    @Indexed(unique = true)
    private String title;

    @NotBlank
    @Indexed(unique = true)
    private String description;
    
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
