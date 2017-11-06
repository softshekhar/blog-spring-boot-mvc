package edu.shekhar.blog.dao;

import edu.shekhar.blog.entity.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository("postgresql")
public class PostgresqlBlogDaoImpl extends JdbcDaoSupport implements BlogDao {

    @Autowired DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    private static class BlogRowMapper implements RowMapper<Blog> {

        @Override
        public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
            Blog blog = new Blog();
            blog.setId(resultSet.getInt("id"));
            blog.setTitle(resultSet.getString("title"));
            blog.setCategories(resultSet.getString("categories"));
            blog.setContent(resultSet.getString("content"));
            return blog;
        }
    }


    @Override
    public Collection<Blog> getAllBlogs() {
        // SELECT column_name(s) FROM table_name
        final String sql = "SELECT id, title, categories, content FROM blogs";
        List<Blog> blogs = getJdbcTemplate().query(sql, new BlogRowMapper());
        return blogs;
    }

    @Override
    public Blog getBlogById(int id) {
        // SELECT column_name(s) FROM table_name where column = value
        final String sql = "SELECT id, title, categories, content FROM blogs where id = ?";
        Blog blog = getJdbcTemplate().queryForObject(sql, new BlogRowMapper(), id);
        return blog;
    }

    @Override
    public void removeBlogById(int id) {
        // DELETE FROM table_name
        // WHERE some_column = some_value
        final String sql = "DELETE FROM blogs WHERE id = ?";
        getJdbcTemplate().update(sql, id);
    }

    @Override
    public void updateBlog(Blog blog) {
        // UPDATE table_name
        // SET column1=value, column2=value2,...
        // WHERE some_column=some_value
        final String sql = "UPDATE blogs SET title = ?, categories = ?, content= ? WHERE id = ?";
        final int id = blog.getId();
        final String title = blog.getTitle();
        final String categories = blog.getCategories();
        final String content = blog.getContent();
        getJdbcTemplate().update(sql, new Object[]{title, categories, content, id});
    }

    @Override
    public void insertBlogToDb(Blog blog) {
        // INSERT INTO table_name (column1, column2, column3,...)
        // VALUES (value1, value2, value3,...)
        final String sql = "INSERT INTO blogs (title, categories, content) VALUES (?, ?, ?)";
        final String title = blog.getTitle();
        final String categories = blog.getCategories();
        final String content = blog.getContent();
        getJdbcTemplate().update(sql, new Object[]{title, categories, content});

    }
}
