package com.SitesManagement.servlet;

import com.bean.Category;
import com.dao.CategoryDao;
import com.dao.SchoolDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteCategory extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("deleteCategory");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Cache-Control","no-cache");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        CategoryDao Dao = new CategoryDao();
        int category_id = Integer.parseInt(req.getParameter("category_id"));
        int result = 0;
        try {
            result =  Dao.deleteCategory(category_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (result > 0 ){
            writer.write(String.valueOf(true));
        } else {
            writer.write(String.valueOf(false));
        }
    }
}
