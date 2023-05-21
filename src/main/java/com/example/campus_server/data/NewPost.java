package com.example.campus_server.data;

import java.io.Serializable;

public class NewPost implements Serializable {
    String title;
    int stag_id;
    int ttag_id;
    String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStag_id() {
        return stag_id;
    }

    public void setStag_id(int stag_id) {
        this.stag_id = stag_id;
    }

    public int getTtag_id() {
        return ttag_id;
    }

    public void setTtag_id(int ttag_id) {
        this.ttag_id = ttag_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "NewPost{" +
                "title='" + title + '\'' +
                ", stag_id=" + stag_id +
                ", ttag_id=" + ttag_id +
                ", content='" + content + '\'' +
                '}';
    }
}
