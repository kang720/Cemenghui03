package com.example.cemenghui03.entity;

public class MeetingBean {
    private String name;
    private String desc;
    private String data;
    private String location;
    private String company;
    private String process;
    private String attendence;
    private int img;

    public MeetingBean(String name, String desc, String data, String location, String company, String process, String attendence, int img) {
        this.name = name;
        this.desc = desc;
        this.data = data;
        this.location = location;
        this.company = company;
        this.process = process;
        this.attendence = attendence;
        this.img = img;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getAttendence() {
        return attendence;
    }

    public void setAttendence(String attendence) {
        this.attendence = attendence;
    }
}
