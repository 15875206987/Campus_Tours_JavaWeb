package com.bean;

public class Category {
    private int category_id;
    private String category_name;
    private int category_parent;

    public int getCategory_id() {
        return category_id;
    }

    public int getCategory_parent() {
        return category_parent;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public void setCategory_parent(int category_parent) {
        this.category_parent = category_parent;
    }
    public Category(){
        super();
    }
}
