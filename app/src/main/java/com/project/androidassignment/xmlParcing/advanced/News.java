package com.project.androidassignment.xmlParcing.advanced;

public class News {
    private String title, des;

    public News(String title, String des) {
        this.title = title;
        this.des = des;
    }

    public News(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
