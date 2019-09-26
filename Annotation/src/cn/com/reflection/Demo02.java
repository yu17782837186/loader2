package cn.com.reflection;

import cn.com.reflection.bean.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings("all")
public class Demo02 {
    //通过反射API动态的操作：构造器，方法，属性
    public static void main(String[] args) {
        String path = "cn.com.reflection.bean.User";
        try {
//            Class<User> clazz = (Class<User>) Class.forName(path);
            Class clazz = Class.forName(path);

            //通过反射API调用构造方法，构造对象
            User u = (User) clazz.newInstance();//其实是调用了User的无参构造器
            System.out.println(u);
            //通过传递参数类型获得对应的构造方法，然后通过newInstance()传递实参得到对象
            Constructor c = clazz.getDeclaredConstructor(int.class,int.class,String.class);
            User u2 = (User) c.newInstance(1001,13,"小红");
            System.out.println(u2.getName());

            //通过反射API调用普通方法
            User u3 = (User) clazz.newInstance();
            Method m = clazz.getDeclaredMethod("setName", String.class);
            m.setAccessible(true);
            m.invoke(u3,"小明");//激活
            System.out.println(u3.getName());

            //通过反射API操作属性
            User u4 = (User) clazz.newInstance();
            Field f = clazz.getDeclaredField("name");
            f.setAccessible(true);//这个属性不用做安全检查了，可以直接访问(也就是访问各种权限)
            f.set(u4,"小亮");//通过反射直接写属性的值
            System.out.println(u4.getName());//通过反射直接读属性的值
            System.out.println(f.get(u4));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
