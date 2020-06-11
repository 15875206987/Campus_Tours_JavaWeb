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
    public String getCategory() throws SQLException {
        String sql = "select * from categories";
        List<Category> categoryList = queryMulti(sql,Category.class);
        Gson gson = new Gson();
        return gson.toJson(categoryList);
    }
    public int deleteCategory(int id) throws Exception{
        String sql = "delete from categories where category_id = ?";
        return update(sql,id);
    }
    public int updateCategory(int c_id,String c_name,int c_parent) throws SQLException {
        String sql = "update categories set category_name = ?,category_parent = ? where category_id = ?";
        return update(sql, c_name,c_parent,c_id);
    }
    public int addCategory(String c_name,int c_parent) throws SQLException {
        String sql = "insert into categories(category_name,category_parent) values(?,?)";
        return update(sql, c_name,c_parent);
    }
}
