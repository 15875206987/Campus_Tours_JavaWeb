package com.bean;

public class University {
    String university_name;
    String university_desc;
    String university_picURL;
    double center_lng;
    double center_lat;

    public double getCenter_lat() {
        return center_lat;
    }

    public double getCenter_lng() {
        return center_lng;
    }

    public String getUniversity_desc() {
        return university_desc;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public String getUniversity_picURL() {
        return university_picURL;
    }

    public void setUniversity_desc(String university_desc) {
        this.university_desc = university_desc;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public void setUniversity_picURL(String university_picURL) {
        this.university_picURL = university_picURL;
    }

    public void setCenter_lat(double center_lat) {
        this.center_lat = center_lat;
    }

    public void setCenter_lng(double center_lng) {
        this.center_lng = center_lng;
    }

}
