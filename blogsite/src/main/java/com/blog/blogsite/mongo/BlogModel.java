package com.blog.blogsite.mongo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="BlogModelDB")
public class BlogModel{
    @Id
    private long id;

    @NotBlank
    @Size(max = 100)
    @Indexed(unique = true)
    private String author; 

    @NotBlank
    private String description;

    @NotBlank
    @Size(max=200)
    private String title;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
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