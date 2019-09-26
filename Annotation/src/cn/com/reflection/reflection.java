package cn.com.reflection;
//压制所有的警告
@SuppressWarnings("all")
public class reflection {
    //测试反射  一个类加载之后 在堆内存中就产生了一个Class对象（一个类只有一个Class对象）
    //这个对象就包含了这个类的完整的结构的信息
    //以及获取Class对象三种方式
    public static void main(String[] args) {
        String path = "cn.com.reflection.bean.User";
        try {
            //第一种方式Class.forName();
            Class clazz = Class.forName(path);
            //类的整个信息都会被放到对应的Class对象中
            System.out.println(clazz);
            System.out.println(clazz.hashCode());

            Class clazz2 = Class.forName(path);
            System.out.println(clazz2.hashCode());
            //第二种方式.class
            Class strClazz = String.class;
            //第三种方式 通过对象的.getClass()方式来获取对象
            Class strClazz2 = path.getClass();
            System.out.println(strClazz == strClazz2);

            Class intClazz = int.class;
            int[] arr01 = new int[10];
            int[] arr02 = new int[20];
            int[][] arr03 = new int[3][];
            double[] arr04 = new double[5];
            System.out.println(arr01.getClass().hashCode());
            System.out.println(arr02.getClass().hashCode());
            System.out.println(arr03.getClass().hashCode());
            System.out.println(arr04.getClass().hashCode());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
