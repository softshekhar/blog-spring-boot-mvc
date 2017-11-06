package edu.shekhar.blog.dao;

import edu.shekhar.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;

@Repository
@Qualifier("mongoData")
public class MongoBlogDaoImpl implements BlogDao {


    @Override
    public Collection<Blog> getAllBlogs() {
        return new ArrayList<Blog>(){
            {
                add(new Blog(1, "Mario", "Nothing", "Nothing at all"));
            }
        };
    }

    @Override
    public Blog getBlogById(int id) {
        return null;
    }

    @Override
    public void removeBlogById(int id) {

    }

    @Override
    public void updateBlog(Blog blog) {

    }

    @Override
    public void insertBlogToDb(Blog blog) {

    }
}
