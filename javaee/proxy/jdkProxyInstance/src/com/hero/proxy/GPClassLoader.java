package com.hero.proxy;

import java.io.*;

/**
 * @description: GPClassLoader
 * @date: 2020/11/21
 * @author: bear
 * @version: 1.0
 */
public class GPClassLoader extends ClassLoader{
    private File classPathFile;

    public GPClassLoader() {
        String classPath = GPClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if (classPathFile != null) {
            File classFile = new File(classPathFile, name.replace("\\.", "/") + ".class");
            if (classFile.exists()) {
                FileInputStream fileInputStream = null;
                ByteArrayOutputStream byteArrayOutputStream = null;

                try {
                    fileInputStream = new FileInputStream(classFile);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = fileInputStream.read(buff)) != -1) {
                        byteArrayOutputStream.write(buff, 0, len);
                    }
                    return defineClass(className, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size())
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
