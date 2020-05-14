package com.dao;

import com.bean.Major;
import com.google.gson.Gson;
import com.util.Base64Img;

import java.sql.SQLException;
import java.util.List;

public class MajorDao extends BasicDao<Major> {
    public String getMajorList() throws SQLException {
        String sql = "select * from majors";
        List<Major> majorList = queryMulti(sql,Major.class);
        Gson gson = new Gson();
        return gson.toJson(majorList);
    }

    public int addMajor(String s) throws Exception {
        Gson gson = new Gson();
        Major major = gson.fromJson(s,Major.class);
        String major_picURL = "https:\\\\localhost:8443\\SCUT_Tour_JavaWeb\\Image\\major_photo\\" + major.getSchool_id() + "\\" + major.getMajor_name() + ".jpg";
        String baseURL = "D:\\IdeaWorkspace\\SCUT_Tour_JavaWeb\\web\\Image\\major_photo\\" + major.getSchool_id() + "\\" + major.getMajor_name() + ".jpg";
        //写文件夹
        try {
            String links = major.getMajor_photo().replaceAll(" ", "+");
            if(links.startsWith("data:image")) {
                //把"data:image/jpeg;base64,AKLJF9.."分割成{"data:image/jpg;base64,","AKLJF9.."}两部分
                String[] imgData = links.split("base64,",0);
                Base64Img.base64ToImg(imgData[1],baseURL);
            }else {
                System.out.println("失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //存数据库
        String sql = "insert into majors(major_name,major_desc,major_picURL,school_id) values(?,?,?,?)";
        return update(sql,major.getMajor_name(),major.getMajor_desc(),major_picURL,major.getSchool_id());
    }
}
