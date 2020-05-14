package com.bean;

public class WechatMarker {
    public int site_id;
    public String site_name;
    public int category_id;
    public double longitude;
    public double latitude;
    public String site_desc;
    public String site_picURL;

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setSite_desc(String site_desc) {
        this.site_desc = site_desc;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
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

    public WechatMarker(){
        super();
    }

    public WechatMarker(Site site){
        site_id = site.site_id;
        site_name = site.site_name;
        site_desc = site.site_desc;
        site_picURL = site.site_picURL;
        category_id = site.category_id;
        longitude = site.site_lng;
        latitude = site.site_lat;
    }
}
