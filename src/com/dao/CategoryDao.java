package com.dao;

import com.bean.Category;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

public class CategoryDao extends BasicDao<Category> {
    public String getLivingCategory() throws SQLException {
        String sql = "select * from categories where category_parent = 1";
        List<Category> categoryList = queryMulti(sql,Category.class);
        Gson gson = new Gson();
        return gson.toJson(categoryList);
    }
    public String getStudyCategory() throws SQLException {
        String sql = "select * from categories where category_parent = 2";
        List<Category> categoryList = queryMulti(sql,Category.class);
        Gson gson = new Gson();
        return gson.toJson(categoryList);
    }
}
