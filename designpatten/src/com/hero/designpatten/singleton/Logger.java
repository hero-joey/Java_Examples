package com.hero.designpatten.singleton;

import com.sun.javafx.runtime.SystemProperties;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @description: Logger
 * @date: 2021/3/2 11:14
 * @author: maccura
 * @version: 1.0
 */
public class Logger {
    private FileWriter fileWriter;
    private static  Logger instance;

    static {
        try {
            instance = new Logger();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Logger() throws IOException {
        File file = new File("");
        fileWriter = new FileWriter(file, true);
    }

    public void log(String message) throws IOException {
        synchronized (Logger.class) {
            fileWriter.write(message);
        }
    }

    public static Logger getInstance() {
        return instance;
    }
}
