package com.blog.blogsite.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.blogsite.exception.ResourceNotFoundException;
import com.blog.blogsite.mongo.BlogModel;
import com.blog.blogsite.mongo.InputModel;
import com.blog.blogsite.repository.BlogModelRepository;

@Service
@Transactional
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogModelRepository blogModelRepository;

    @Override
    public BlogModel createBlogModel(InputModel blogModel) {
        List<BlogModel> bm=this.blogModelRepository.findAll();
        BlogModel inp= new BlogModel();

        inp.setId(bm.size()+1);
        inp.setAuthor(blogModel.getAuthor());
        inp.setTitle(blogModel.getTitle());
        inp.setDescription(blogModel.getDescription());
                
        return blogModelRepository.save(inp);
    }

    @Override
    public BlogModel updateBlogModel(BlogModel blogModel) {
       
        Optional < BlogModel > blogModelDb = this.blogModelRepository.findById(blogModel.getId());

        if (blogModelDb.isPresent()) {
            BlogModel productUpdate = blogModelDb.get();
            productUpdate.setAuthor(blogModel.getAuthor());
            productUpdate.setTitle(blogModel.getTitle());
            productUpdate.setDescription(blogModel.getDescription());
            blogModelRepository.save(productUpdate);
            return productUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + blogModel.getId());
        }
    }

    @Override
    public List<BlogModel> getAllBlogModel() {
        
        return this.blogModelRepository.findAll();
    }

    @Override
    public BlogModel getBlogModelById(long blogModelId) {
        

        Optional < BlogModel > blogModelDb = this.blogModelRepository.findById(blogModelId);

        if (blogModelDb.isPresent()) {
            return blogModelDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + blogModelId);
        }
    }

    @Override
    public void deleteBlogModel(long id) {
        
        Optional < BlogModel > blogModelDb = this.blogModelRepository.findById(id);

        if (blogModelDb.isPresent()) {
            this.blogModelRepository.delete(blogModelDb.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : " + id);
        }
    }
    
}
