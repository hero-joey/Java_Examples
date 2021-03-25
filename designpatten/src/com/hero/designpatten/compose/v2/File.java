package com.hero.designpatten.compose.v2;

/**
 * @description: File
 * @date: 2021/3/23 9:19
 * @author: maccura
 * @version: 1.0
 */
public class File extends FileSystemNode {
    public File(String path) {
        super(path);
    }

    @Override
    public int countNumOfFiles() {
        return 1;
    }

    @Override
    public long countSizeOfFiles() {
        java.io.File file = new java.io.File(path);
        if (!file.exists()) {
            return 0;
        }

        return file.length();
    }
}
