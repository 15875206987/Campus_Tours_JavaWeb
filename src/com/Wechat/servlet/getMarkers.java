package com.Wechat.servlet;

import com.dao.SiteDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class getMarkers extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("getWechatMarkers");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Cache-Control","no-cache");
        response.setContentType("text/json; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        SiteDao siteDao = new SiteDao();
        String s = null;
        try {
            s = siteDao.getWechatMarkers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        writer.write(s);
    }
}
