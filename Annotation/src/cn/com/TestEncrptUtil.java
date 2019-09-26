package cn.com;

import cn.com.lodar.DecrptClassLoader;
import cn.com.lodar.FileSystemClassLoader;


public class TestEncrptUtil {
    public static void main(String[] args) throws ClassNotFoundException {
        //正常的类加载器无法加载，必须使用解密的类加载器加载
        FileSystemClassLoader loader = new FileSystemClassLoader("F:/myjava/tmp");
        Class<?> c = loader.loadClass("HelloWord");
        System.out.println(c);
//        DecrptClassLoader loader = new DecrptClassLoader("F:/myjava/tmp");
//        Class<?> c = loader.loadClass("HelloWord");
//        System.out.println(c);
    }
}
