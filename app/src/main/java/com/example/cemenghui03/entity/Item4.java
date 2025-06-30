package com.example.cemenghui03.entity;

public class Item4 {
    private int img;
    private String name;
    private String introduction;
    private String content;
    private String date;

    public Item4(int img, String name, String introduction, String content, String date) {
        this.img = img;
        this.name = name;
        this.introduction = introduction;
        this.content = content;
        this.date = date;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
