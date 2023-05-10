package com.example.campus_server.entity;

import java.io.Serializable;

public class Tag implements Serializable {
    private int tag_id;
    private String tag_name;
    private char tag_type;
    private String style;

    @Override
    public String toString() {
        return "Tag{" +
                "tag_id=" + tag_id +
                ", tag_name='" + tag_name + '\'' +
                ", tag_type=" + tag_type +
                ", style='" + style + '\'' +
                '}';
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public char getTag_type() {
        return tag_type;
    }

    public void setTag_type(char tag_type) {
        this.tag_type = tag_type;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
