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
}
