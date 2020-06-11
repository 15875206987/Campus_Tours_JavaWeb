package com.dao;

import com.bean.School;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

public class SchoolDao extends BasicDao<School> {
    public String getSchoolList() throws SQLException {
        String sql = "select * from schools";
        List<School> schoolList = queryMulti(sql,School.class);
        Gson gson = new Gson();
        return gson.toJson(schoolList);
    }
    public int deleteSchool(int id) throws Exception{
        String sql = "delete from schools where school_id = ?";
        return update(sql,id);
    }
    public int updateSchool(int s_id,String s_name) throws SQLException {
        String sql = "update schools set school_name = ? where school_id = ?";
        return update(sql, s_name, s_id);
    }
    public int addSchool(String s_name) throws SQLException {
        String sql = "insert into schools(school_name) values(?)";
        return update(sql, s_name);
    }
}
