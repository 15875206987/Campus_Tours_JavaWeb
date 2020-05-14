package com.bean;

public class Major {
    private int major_id;
    private String major_name;
    private String major_desc;
    private String major_picURL;
    private int school_id;
    private String major_photo; //这个是前端传过来的时候存base64编码的

    public String getMajor_photo() {
        return major_photo;
    }

    public void setMajor_photo(String major_photo) {
        this.major_photo = major_photo;
    }

    public int getSchool_id() {
        return school_id;
    }

    public void setSchool_id(int school_id) {
        this.school_id = school_id;
    }

    public int getMajor_id() {
        return major_id;
    }

    public String getMajor_desc() {
        return major_desc;
    }

    public String getMajor_name() {
        return major_name;
    }

    public String getMajor_picURL() {
        return major_picURL;
    }

    public void setMajor_desc(String major_desc) {
        this.major_desc = major_desc;
    }

    public void setMajor_id(int major_id) {
        this.major_id = major_id;
    }

    public void setMajor_name(String major_name) {
        this.major_name = major_name;
    }

    public void setMajor_picURL(String major_picURL) {
        this.major_picURL = major_picURL;
    }

    public Major(){
        super();
    }
}
