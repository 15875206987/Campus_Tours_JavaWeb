package com.bean;

public class Site {
    public int site_id;
    public String site_name;
    public int category_id;
    public double site_lng;
    public double site_lat;
    public String site_desc;
    public String site_picURL;
    public String site_photo; //这个是前端传过来的时候存base64编码的

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setSite_desc(String site_desc) {
        this.site_desc = site_desc;
    }

    public void setSite_lat(double site_lat) {
        this.site_lat = site_lat;
    }

    public void setSite_lng(double site_lng) {
        this.site_lng = site_lng;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public double getSite_lat() {
        return site_lat;
    }

    public double getSite_lng() {
        return site_lng;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getSite_desc() {
        return site_desc;
    }

    public String getSite_name() {
        return site_name;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getSite_picURL() {
        return site_picURL;
    }

    public void setSite_picURL(String site_picURL) {
        this.site_picURL = site_picURL;
    }

    public String getSite_photo() {
        return site_photo;
    }

    public void setSite_photo(String site_photo) {
        this.site_photo = site_photo;
    }

    public Site(){
        super();
    }
}
