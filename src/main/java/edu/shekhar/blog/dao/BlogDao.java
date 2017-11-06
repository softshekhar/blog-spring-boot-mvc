package edu.shekhar.blog.dao;

import edu.shekhar.blog.entity.Blog;

import java.util.Collection;

public interface BlogDao {
    Collection<Blog> getAllBlogs();

    Blog getBlogById(int id);

    void removeBlogById(int id);

    void updateBlog(Blog blog);

    void insertBlogToDb(Blog blog);
}
