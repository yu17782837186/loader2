package cn.com.lodar;

public class Demo01 {
    static {
        System.out.println("静态初始化Demo01");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Demo01的main方法");
        //主动引用（一定会发生类的初始化）4点
//        Student student = new Student();//1.new对象
//        System.out.println(student.age);
        //Student student1 = new Student(); //一个类只被加载一次
        //System.out.println(Student.age);
        //Class.forName("cn.com.lodar.Student");//2.反射调用
        //3.初始化一个类，父类没有被初始化，一定会先初始化父类
        //4.启动main方法所在的类

        //被动引用(不会发生类的初始化)3点
//        System.out.println(Student.MAX); //1.常量在常量池内
//        Student[] students = new Student[10]; //2.数组定义类引用
        System.out.println(Baby.age); //3.只有真正声明这个域的类才会被初始化
    }
}
class Baby extends Student{
    static {
        System.out.println("静态初始化类Baby");
    }
}
class Student extends Persion{
    public static int age = 18;
    public static final int MAX = 100;
    static {
        System.out.println("静态初始化类Student");
        age = 19;
    }

    public Student() {
        System.out.println("创建Student类的对象");
    }
}
class Persion {
    static {
        System.out.println("静态初始化类Persion");
    }
}