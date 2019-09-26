package cn.com.lodar;

public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());//获得系统的类加载器 应用程序类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent());//扩展类加载器
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));

    }
}
