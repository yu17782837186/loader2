package cn.com.lodar;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class NetSystemClassLoader extends ClassLoader{
    private String rootUrl;

    public NetSystemClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
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
                byte[] URLData = getURLData(name);
                if (URLData == null) {
                    throw new ClassNotFoundException();
                }else {
                    c = defineClass(name,URLData,0,URLData.length);
                }
            }
        }
        return c;
    }
    private byte[] getURLData(String urlname) {
        String path = this.rootUrl+"/"+urlname.replace('.','/')+".txt";
        InputStream is = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            URL url = new URL(path);
            is = url.openStream();
            byte[] bytes = new byte[1024];
            int tmp;
            while((tmp = is.read(bytes)) != -1) {
                baos.write(bytes,0,tmp);
            }
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e) {
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
