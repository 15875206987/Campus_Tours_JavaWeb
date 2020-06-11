package com.SchoolIntro.servlet;

import com.bean.School;
import com.dao.MajorDao;
import com.dao.SchoolDao;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteSchool  extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("deleteSchool");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Cache-Control","no-cache");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        SchoolDao schoolDao = new SchoolDao();
        int s_id = Integer.parseInt(req.getParameter("school_id"));
        int result = 0;
        try {
            result =  schoolDao.deleteSchool(s_id);
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
