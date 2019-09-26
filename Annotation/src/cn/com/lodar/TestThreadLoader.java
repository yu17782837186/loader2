package cn.com.lodar;

public class TestThreadLoader {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = TestThreadLoader.class.getClassLoader();
        System.out.println(loader);

        //获得线程上下文加载器
        ClassLoader loader1 = Thread.currentThread().getContextClassLoader();
        System.out.println(loader1);
        //更改加载器
        Thread.currentThread().setContextClassLoader(new FileSystemClassLoader("F:/myjava"));
        System.out.println(Thread.currentThread().getContextClassLoader());

        Class<?> c = Thread.currentThread().getContextClassLoader().loadClass("cn.com.lodar.Demo01");
        System.out.println(c);
        System.out.println(c.getClassLoader());
    }
}
