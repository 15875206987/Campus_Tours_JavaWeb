package com.SitesManagement.servlet;

import com.dao.SiteDao;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class removeSite extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("removeSite");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Cache-Control","no-cache");
        resp.setContentType("text/json; charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        SiteDao siteDao = new SiteDao();
        int i = Integer.parseInt(req.getParameter("site_id"));
        int result = 0;
        try {
            result =  siteDao.removeSites(i);
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
