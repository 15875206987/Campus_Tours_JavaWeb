package com.dao;

import com.bean.Category;
import com.bean.University;
import com.google.gson.Gson;

import java.sql.SQLException;
import java.util.List;

public class UnivarsityDao extends BasicDao<University> {
    public String getUniversity() throws SQLException {
        String sql = "select * from university";
        List<University> universityList = queryMulti(sql,University.class);
        Gson gson = new Gson();
        return gson.toJson(universityList);
    }
}
