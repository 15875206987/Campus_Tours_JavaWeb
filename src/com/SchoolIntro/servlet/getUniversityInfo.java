package com.SchoolIntro.servlet;

import com.dao.SchoolDao;
import com.dao.UnivarsityDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class getUniversityInfo extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        System.out.println("getUniversityInfo");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        UnivarsityDao Dao = new UnivarsityDao();
        PrintWriter writer = response.getWriter();
        String s = null;
        try {
            s = Dao.getUniversity();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        writer.write(s);
    }
}
