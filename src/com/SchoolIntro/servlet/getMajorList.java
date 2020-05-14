package com.SchoolIntro.servlet;

import com.dao.MajorDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class getMajorList extends javax.servlet.http.HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        System.out.println("getMajorList");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        MajorDao majorDao = new MajorDao();
        PrintWriter writer = response.getWriter();
        String s = null;
        try {
            s = majorDao.getMajorList();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        writer.write(s);
    }
}