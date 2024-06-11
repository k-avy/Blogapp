package com.blog.blogsite.service;

import java.util.List;

import com.blog.blogsite.mongo.BlogModel;
import com.blog.blogsite.mongo.InputModel;

public interface BlogService {
    BlogModel createBlogModel(InputModel blogModel);

    BlogModel updateBlogModel(BlogModel blogModel);

    List < BlogModel > getAllBlogModel();

    BlogModel getBlogModelById(long blogModelId);

    void deleteBlogModel(long id);
}
