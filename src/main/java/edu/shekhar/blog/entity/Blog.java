package edu.shekhar.blog.entity;

public class Blog {

    private int id;
    private String title;
    private String categories;
    private String content;


    public Blog(int id, String title, String categories, String content) {
        this.id = id;
        this.title = title;
        this.categories = categories;
        this.content = content;
    }

    public Blog(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
