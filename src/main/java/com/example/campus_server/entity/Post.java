package com.example.campus_server.entity;

import java.io.Serializable;
import java.sql.Date;

public class Post implements Serializable {
    private int post_id;
    private int author_id;
    private String author_name;
    private String title;
    private int type_tag;
    private String ttag_name;
    private int status_tag;
    private String stag_name;
    private Date create_time;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType_tag() {
        return type_tag;
    }

    public void setType_tag(int type_tag) {
        this.type_tag = type_tag;
    }

    public String getTtag_name() {
        return ttag_name;
    }

    public void setTtag_name(String ttag_name) {
        this.ttag_name = ttag_name;
    }

    public int getStatus_tag() {
        return status_tag;
    }

    public void setStatus_tag(int status_tag) {
        this.status_tag = status_tag;
    }

    public String getStag_name() {
        return stag_name;
    }

    public void setStag_name(String stag_name) {
        this.stag_name = stag_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
