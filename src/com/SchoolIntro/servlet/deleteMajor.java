package com.SchoolIntro.servlet;

import com.dao.MajorDao;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class deleteMajor extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("deleteMajor");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Cache-Control","no-cache");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        MajorDao majorDao = new MajorDao();
        int m_id = Integer.parseInt(req.getParameter("major_id"));
        int s_id = Integer.parseInt(req.getParameter("school_id"));
        String m_name = req.getParameter("major_name");
        boolean result = false;
        try {
            result =  majorDao.deleteMajor(m_id,s_id,m_name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.write(String.valueOf(result));
    }
}
