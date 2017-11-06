package edu.shekhar.blog.controller;

import edu.shekhar.blog.entity.Blog;
import edu.shekhar.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/blogs")
@CrossOrigin
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Blog> getAllBlogs(){
        return blogService.getAllBlogs();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Blog getBlogById(@PathVariable("id") int id){
        return blogService.getBlogById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBlogById(@PathVariable("id") int id){
        blogService.removeBlogById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void deleteBlogById(@RequestBody Blog blog){
        blogService.updateBlog(blog);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertBlog(@RequestBody Blog blog){
        blogService.insertBlog(blog);
    }
}
