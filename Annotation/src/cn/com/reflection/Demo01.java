package cn.com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
@SuppressWarnings("all")
public class Demo01 {
    //测试应用反射的API，获取类的信息（类的名字，属性，方法，构造器）
    public static void main(String[] args) {
        String path = "cn.com.reflection.bean.User";
        try {
            Class clazz = Class.forName(path);
            //获取类的名字
            System.out.println(clazz.getName());//获取包名加类名
            System.out.println(clazz.getSimpleName());//获取类名
            //获取属性信息
//            Field[] f = clazz.getFields();//只能获得公开的属性 public修饰
            Field[] f = clazz.getDeclaredFields();//获得所有的属性
            Field f1 = clazz.getDeclaredField("id");//获得id这个属性
            System.out.println(f1.getName());
            System.out.println(f.length);
            for (Field field:f) {
                System.out.println("属性："+field);
            }
            //获取方法信息
            Method[] m = clazz.getDeclaredMethods();//获取所有的方法
//            Method m1 = clazz.getDeclaredMethod("getId",null);//获得具体的属性
//            Method m2 = clazz.getDeclaredMethod("setId", int.class);//避免重载出现问题，如果方法有参，则必须传递参数类型对应的Class对象
//            System.out.println(m1.getName());
//            System.out.println(m2.getName());
            System.out.println(m.length);
            for (Method method:m) {
                System.out.println("方法："+method);
            }
            //获取构造器信息
            Constructor[] c = clazz.getDeclaredConstructors();
            Constructor c1 = clazz.getDeclaredConstructor(null);
            Constructor c2 = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            System.out.println("获得构造器："+c1);
            System.out.println("获得构造器："+c2);
            System.out.println(c.length);
            for (Constructor constructor:c) {
                System.out.println("构造器："+constructor);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
