package cn.com.lodar;

import java.io.File;

public class TestFileSystemClassLoader {
    public static void main(String[] args) throws ClassNotFoundException {
//        FileSystemClassLoader loader = new FileSystemClassLoader("F:/myjava");
//        FileSystemClassLoader loader1 = new FileSystemClassLoader("F:/myjava");
//        Class<?> c = loader.loadClass("cn.com.test.HelloWord");
//        Class<?> c2 = loader.loadClass("cn.com.test.HelloWord");
//        Class<?> c3 = loader1.loadClass("cn.com.test.HelloWord");
//        Class<?> c4 = loader1.loadClass("java.lang.String");
//        Class<?> c5 = loader1.loadClass("cn.com.lodar.Demo02");
////        System.out.println(c);
//        System.out.println(c.hashCode());//同一个类加载器加载同一个类，JVM才认为是同一个类
//        System.out.println(c2.hashCode());
//        System.out.println(c3.hashCode());//不是同一个类加载器加载同一个类，JVM认为是不同的类
//        System.out.println(c4.hashCode());
//        System.out.println(c3.getClassLoader()); //自定义类加载器
//        System.out.println(c4.getClassLoader()); //引导类加载器
//        System.out.println(c5.getClassLoader()); //系统默认的类加载器
        FileSystemClassLoader loader = new FileSystemClassLoader("F:/myjava");
        FileSystemClassLoader loader1 = new FileSystemClassLoader("F:/myjava");
        Class<?> c = loader.loadClass("cn.com.test.HelloWord");
        Class<?> c2 = loader.loadClass("cn.com.test.HelloWord");
        Class<?> c3 = loader1.loadClass("cn.com.test.HelloWord");
        Class<?> c4 = loader1.loadClass("java.lang.String");
        Class<?> c5 = loader1.loadClass("cn.com.lodar.Demo02");
        System.out.println(c);
        System.out.println(c2);
        System.out.println(c.hashCode());
        System.out.println(c == c2);
        System.out.println(c2 == c3);

        System.out.println(c3.getClassLoader());
        System.out.println(c4.getClassLoader());
        System.out.println(c5.getClassLoader());
    }
}
