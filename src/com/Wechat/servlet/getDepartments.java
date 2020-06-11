package com.Wechat.servlet;

import com.dao.SchoolDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class getDepartments extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        System.out.println("getSchoolList");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        SchoolDao schoolDao = new SchoolDao();
        PrintWriter writer = response.getWriter();
        String s = null;
        try {
            s = schoolDao.getSchoolList();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        writer.write(s);
    }
}