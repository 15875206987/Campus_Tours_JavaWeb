package com.SchoolIntro.servlet;

import com.dao.MajorDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class updateMajor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        System.out.println("updateMajor");
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        StringBuilder responseStrBuilder = new StringBuilder();
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null){
            responseStrBuilder.append(inputStr);
        }
        System.out.println(responseStrBuilder.toString());
        MajorDao majorDao = new MajorDao();
        int result = 0;
        try {
            result = majorDao.updateMajor(responseStrBuilder.toString());
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
}
