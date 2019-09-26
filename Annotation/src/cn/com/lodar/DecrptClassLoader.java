package cn.com.lodar;



import java.io.*;

public class DecrptClassLoader extends ClassLoader{
    private String rootDir;

    public DecrptClassLoader(String rootDir) {
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
                byte[] data = getData(name);
                if (data ==null) {
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,data,0,data.length);
                }
            }
        }
        return c;
    }
    private byte[] getData(String dataname) {
        String path = this.rootDir+"/"+dataname.replace('.','/')+".class";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            is = new FileInputStream(path);
            int tmp;
            while((tmp = is.read()) != -1) {
                baos.write(tmp^0xff);
            }
            baos.flush();
            return baos.toByteArray();
        } catch(Exception e) {
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
