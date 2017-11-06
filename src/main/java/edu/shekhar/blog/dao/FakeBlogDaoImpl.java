package edu.shekhar.blog.dao;

import edu.shekhar.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeBlogDaoImpl implements BlogDao {

    private static Map<Integer, Blog> blogs;

    static {

        blogs = new HashMap<Integer, Blog>(){

            {
                put(1, new Blog(1, "Said", "Computer Science", "hello cs"));
                put(2, new Blog(2, "Alex U", "Finance", "hello finance"));
                put(3, new Blog(3, "Anna", "Maths", "hello maths"));
            }
        };
    }

    @Override
    public Collection<Blog> getAllBlogs(){
        return this.blogs.values();
    }

    @Override
    public Blog getBlogById(int id){
        return this.blogs.get(id);
    }

    @Override
    public void removeBlogById(int id) {
        this.blogs.remove(id);
    }

    @Override
    public void updateBlog(Blog blog){
        Blog s = blogs.get(blog.getId());
        s.setCategories(blog.getCategories());
        s.setTitle(blog.getTitle());
        blogs.put(blog.getId(), blog);
    }

    @Override
    public void insertBlogToDb(Blog blog) {
        this.blogs.put(blog.getId(), blog);
    }
}
