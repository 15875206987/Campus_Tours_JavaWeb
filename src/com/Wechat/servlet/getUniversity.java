package com.Wechat.servlet;

import com.dao.UnivarsityDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class getUniversity extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getLivingCategories");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        UnivarsityDao univarsityDao = new UnivarsityDao();
        PrintWriter writer = response.getWriter();
        String s = null;
        try {
            s = univarsityDao.getUniversity();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        writer.write(s);
    }
}
