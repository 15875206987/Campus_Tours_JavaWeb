package com.UniversityMap.servlet;

import com.dao.SiteDao;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class addSite extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println("addSite");
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null){
            responseStrBuilder.append(inputStr);
        }
        System.out.println(responseStrBuilder.toString());
        SiteDao siteDao = new SiteDao();
        String basePath = request.getServletContext().getRealPath("");
        System.out.println(basePath);
        int result = 0;
        try {
            result = siteDao.addSite(responseStrBuilder.toString(),basePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        PrintWriter writer = response.getWriter();
        if (result > 0 ){
            writer.write(String.valueOf(true));
        } else {
            writer.write(String.valueOf(false));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
