package com.util;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64Img {

    static BASE64Encoder encoder = new BASE64Encoder();
    static BASE64Decoder decoder = new BASE64Decoder();
    /**
     * 将BASE64转为图片
     * @param imgStr 图片BASE64编码
     * @param savePath 图片保存路径
     * @return
     */
    public static Boolean base64ToImg (String imgStr, String savePath) throws IOException{

        if (imgStr == null){//图像数据为空
            return false;
        }
        File file = new File(savePath);
        OutputStream out=null;
        if(!file.getParentFile().exists()){
            //先得到文件的上级目录，并创建上级目录，在创建文件
            file.getParentFile().mkdirs();
        }
        try {
            out = new FileOutputStream(file);
            //Base64解码
            byte[] b = decoder.decodeBuffer(imgStr);
            for(int i=0;i<b.length;++i)
            {
                if(b[i]<0)
                {//调整异常数据
                    b[i]+=256;
                }
            }
            out.write(b);
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}
