package com.hero.designpatten.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @description: Logger
 * @date: 2021/3/2 11:14
 * @author: maccura
 * @version: 1.0
 */
public class Logger {
    private FileWriter fileWriter;

    public Logger() throws IOException {
        File file = new File("");
        fileWriter = new FileWriter(file, true);
    }

    public void log(String message) throws IOException {
        synchronized (Logger.class) {
            fileWriter.write(message);
        }

    }
}
