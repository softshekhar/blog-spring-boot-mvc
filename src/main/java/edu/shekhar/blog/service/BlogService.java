package edu.shekhar.blog.service;

import edu.shekhar.blog.dao.BlogDao;
import edu.shekhar.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BlogService {

    @Autowired
    @Qualifier("mysql")
    private BlogDao blogDao;

    public Collection<Blog> getAllBlogs(){
        return this.blogDao.getAllBlogs();
    }

    public Blog getBlogById(int id){
        return this.blogDao.getBlogById(id);
    }


    public void removeBlogById(int id) {
        this.blogDao.removeBlogById(id);
    }

    public void updateBlog(Blog blog){
        this.blogDao.updateBlog(blog);
    }

    public void insertBlog(Blog blog) {
        this.blogDao.insertBlogToDb(blog);
    }
}
