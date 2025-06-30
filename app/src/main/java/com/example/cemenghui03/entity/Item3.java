package com.example.cemenghui03.entity;

public class Item3 {
    private int img;
    private String content;
    private String company;



    public Item3(int img, String content, String company) {
        this.img = img;
        this.content = content;
        this.company = company;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
