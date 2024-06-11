package com.blog.blogsite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.blogsite.mongo.BlogModel;
import com.blog.blogsite.mongo.InputModel;
import com.blog.blogsite.service.BlogService;

@RestController
public class Autocontroller {
     @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity <List<BlogModel>> getAllBlog(){
        return ResponseEntity.ok().body(blogService.getAllBlogModel());
    }

    @GetMapping("/blogs/{id}")
    public ResponseEntity <BlogModel> getBlogById(@PathVariable long id){
        return ResponseEntity.ok().body(blogService.getBlogModelById(id));
    }

    @PostMapping("/blogs")
    public ResponseEntity <BlogModel> createBlog(@RequestBody InputModel blogModel){
        return ResponseEntity.ok().body(this.blogService.createBlogModel(blogModel));
    }

    @PutMapping("/blogs/{id}")
    public ResponseEntity <BlogModel> updateBlog(@PathVariable long id, @RequestBody BlogModel blogModel){
        blogModel.setId(id);
        return ResponseEntity.ok().body(this.blogService.updateBlogModel(blogModel));

    }

    @DeleteMapping("/blogs/{id}")
    public HttpStatus deleteBlog(@PathVariable long id){
        this.blogService.deleteBlogModel(id);
        return HttpStatus.OK;
    }
}
