package com.UniversityMap.servlet;

import com.dao.CategoryDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class getStudyCategories extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getLivingCategories");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        CategoryDao categoryDao = new CategoryDao();
        PrintWriter writer = response.getWriter();
        String s = null;
        try {
            s = categoryDao.getStudyCategory();
        } catch (SQLException e) {
            e.printStackTrace();
        };
        writer.write(s);
    }
}
