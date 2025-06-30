package com.example.cemenghui03.entity;

public class Item2 {
    private int img;
    private String time;
    private String title;
    private String author;
    public Item2(){}


    public Item2(int img, String time, String title, String author) {
        this.img = img;
        this.time = time;
        this.title = title;
        this.author = author;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
