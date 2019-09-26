package cn.com.lodar;

import java.io.*;

public class EncrptUtil {
    //加密工具类
    public static void main(String[] args) {
        encrpt(new File("F:/myjava/HelloWord.class"),new File("F:/myjava/tmp/HelloWord.class"));
    }
    public static void encrpt(File src, File dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int tmp;
            while((tmp = fis.read()) != -1) {
                fos.write(tmp^0xff);
            }
            fos.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
