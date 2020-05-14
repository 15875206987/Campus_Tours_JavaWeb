package com.SitesManagement.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class addSitePic extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Method", "GET, POST, PUT, DELETE, OPTIONS");
        resp.setHeader("Cache-Control","no-cache");
        resp.setContentType("text/json; charset=UTF-8");
        System.out.println("addSitePic post");
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(req.getInputStream(),"UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null){
            responseStrBuilder.append(inputStr);
        }
        System.out.println(responseStrBuilder.toString());
    }
}
