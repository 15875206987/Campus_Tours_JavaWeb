package com.dao;

import com.bean.Site;
import com.bean.WechatMarker;
import com.google.gson.Gson;
import com.util.Base64Img;

import java.util.ArrayList;
import java.util.List;

public class SiteDao extends BasicDao<Site> {
    public int addSite(String s) throws Exception {
        Gson gson = new Gson();
        Site site = gson.fromJson(s,Site.class);
        String site_picURL = "https:\\\\localhost:8443\\SCUT_Tour_JavaWeb\\Image\\site_photo\\" + site.category_id + "\\" + site.site_name + ".jpg";
        String baseURL = "D:\\IdeaWorkspace\\SCUT_Tour_JavaWeb\\web\\Image\\site_photo\\" + site.category_id + "\\" + site.site_name + ".jpg";
        //写文件夹
        try {
            String links = site.site_photo.replaceAll(" ", "+");
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
        String sql = "insert into sites(site_name,category_id,site_lng,site_lat,site_desc,site_picURL) values(?,?,?,?,?,?)";
        return update(sql,site.site_name,site.category_id,site.site_lng,site.site_lat,site.site_desc,site_picURL);
    }
    public String getSites() throws Exception{
        String sql = "select * from sites";
        List<Site> siteList = queryMulti(sql,Site.class);
        Gson gson = new Gson();
        return gson.toJson(siteList);
    }
    public int removeSites(int id) throws Exception{
        String sql = "delete from sites where site_id = ?";
        return update(sql,id);
    }
    public  String getWechatMarkers() throws Exception{
        String sql = "select * from sites";
        List<Site> siteList = queryMulti(sql,Site.class);
        Gson gson = new Gson();
        List<WechatMarker> wechatMarkerList = new ArrayList<WechatMarker>();
        System.out.println("----------------------------------1");
        for (int i = 0 ; i < siteList.size(); i++){
            wechatMarkerList.add(new WechatMarker(siteList.get(i)));
        }
        System.out.println("----------------------------------2");
        return gson.toJson(wechatMarkerList);
    }
}
