package com.example.campus_server.entity;

import java.util.Date;

public class Comment {
    private int comment_id;
    private String content;
    private int author_id;
    private int comment_post;
    private int parent_id;
    private Date create_time;

    public int getComment_id() {
        return comment_id;
    }

    public void setComment_id(int comment_id) {
        this.comment_id = comment_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public int getComment_post() {
        return comment_post;
    }

    public void setComment_post(int comment_post) {
        this.comment_post = comment_post;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", content='" + content + '\'' +
                ", author_id=" + author_id +
                ", comment_post=" + comment_post +
                ", parent_id=" + parent_id +
                ", create_time=" + create_time +
                '}';
    }
}
