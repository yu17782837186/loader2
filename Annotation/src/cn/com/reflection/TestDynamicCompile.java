package cn.com.reflection;


import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;


public class TestDynamicCompile {
    //测试动态编译
    public static void main(String[] args) throws IOException {
//        File file = new File("F:/myjava/Hello.java");
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream(file);
//            String str = "public class Hello {public static void main(String[] args){System.out.println(\"hello word\");}}";
//            byte[] bytes = str.getBytes();
//            os.write(bytes,0,bytes.length);
//            os.flush();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            if (os != null) {
//                try {
//                    os.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        int result = compiler.run(null,null,null,"F:/myjava/Hello.java");
//        System.out.println(result == 0?"编译成功":"编译失败");
//
////        //动态的运行
////        Runtime run = Runtime.getRuntime();
////        Process process = run.exec("java -cp F:/myjava Hello");
////        InputStream is = process.getInputStream();
////        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
////        String str ="";
////        while((str = reader.readLine()) != null) {
////            System.out.println(str);
////        }
//        //通过反射
//        try {
//            URL[] urls = new URL[] {new URL("file:/"+"F:/myjava/")};
//            URLClassLoader loader = new URLClassLoader(urls);
//            Class c = loader.loadClass("Hello");
//            //调用加载类的main方法
//            Method m = c.getMethod("main",String[].class);
//            m.invoke(null,(Object) new String[]{"aa","bb"});
//            //由于可变参数是JDK5.0之后才有，上面的代码会编译成m.invoke(null,"aa","bb"),就发生了参数不匹配的问题
//            //因此必须要加上Object转型，避免这个问题
//            //public static void main(String[] args) 只有一个参数
//        }catch(Exception e) {
//            e.printStackTrace();
//        }
//        //获取动态编译器
//        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
//        int result = compiler.run(null,null,null,"F:/myjava/HelloWord.java");
//        System.out.println(result == 0?"编译成功":"编译失败"); //生成.class文件
        File file = new File("F:/myjava/Hello.java");
        OutputStream os = new FileOutputStream(file);
        String str = "public class Hello {public static void main(String[] args){System.out.println(\"hello word\");}}";
        byte[] bytes = str.getBytes();
        os.write(bytes,0,bytes.length);
        os.flush();

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null,null,null,"F:/myjava/Hello.java");
        System.out.println(result == 0?"编译成功":"编译失败");

        Runtime run = Runtime.getRuntime();
        Process process = run.exec("java -cp F:/myjava Hello");
        InputStream is= process.getInputStream();
        BufferedReader redader = new BufferedReader(new InputStreamReader(is));
        String str1 = "";
        while((str1 = redader.readLine()) != null) {
            System.out.println(str1);
        }

        try {
            URL[] urls = new URL[]{new URL("file:/"+"F:/myjava/")};
            URLClassLoader loader = new URLClassLoader(urls);
            Class c = loader.loadClass("Hello");
            Method m = c.getDeclaredMethod("main",String[].class);
            m.invoke(null,(Object) new String[]{});
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}
