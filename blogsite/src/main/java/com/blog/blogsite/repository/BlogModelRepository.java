package com.blog.blogsite.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.blog.blogsite.mongo.BlogModel;

public interface BlogModelRepository extends MongoRepository<BlogModel, Long> {
  
}