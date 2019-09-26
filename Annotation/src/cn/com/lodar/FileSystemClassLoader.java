package cn.com.lodar;




import java.io.*;
@SuppressWarnings("all")
public class FileSystemClassLoader extends ClassLoader{
//    //自定义文件系统类加载器
//    private String rootDir;
//    public FileSystemClassLoader(String rootDir) {
//        this.rootDir = rootDir;
//    }
//    @Override
//    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        Class<?> c = findLoadedClass(name);//查找这个类
//        //查找这个类是否被加载过,如果有，直接返回加载好的类，如果没有，加载新的类
//        if (c != null) {
//            return c;
//        }else {
//            ClassLoader parent = this.getParent();//获得父类的加载器
//            try {
//                c = parent.loadClass(name); //委派给父类加载
//            }catch(Exception e) {
////                e.printStackTrace();
//            }
////            c = parent.loadClass(name);
//            if (c != null) {
//                return c;
//            }else {
//                byte[] classData = getClassData(name);
//                if (classData == null) {
//                    throw new ClassNotFoundException();
//                }else {
//                    c = defineClass(name,classData,0,classData.length);
//                }
//            }
//        }
//        return c;
//    }
//    private byte[] getClassData(String classname){
//        String path = rootDir+"/"+classname.replace('.','/')+".class";
//        InputStream is = null;
//        ByteArrayOutputStream baos = null;
//        try {
//            is = new FileInputStream(path);
//            baos = new ByteArrayOutputStream();
//            byte[] bytes = new byte[1024];
//            int tmp;
//            while((tmp = is.read(bytes)) != -1) {
//                baos.write(bytes,0,tmp);
//            }
//            baos.flush();
//            return baos.toByteArray();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            if (is != null) {
//                try {
//                    is.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        return null;
//    }
    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);
        if (c != null) {
            return c;
        }else {
            ClassLoader parent = this.getParent();
            try {
                c = parent.loadClass(name);
            }catch(Exception e) {
            }
            if (c != null) {
                return c;
            }else {
                byte[] classData = getClassData(name);
                if (classData == null) {
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,classData,0,classData.length);
                }
            }
        }
        return c;
    }
    private byte[] getClassData(String classname) {
        String path = this.rootDir+"/"+classname.replace('.','/')+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            byte[] bytes = new byte[1024];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                baos.write(bytes,0,tmp);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
