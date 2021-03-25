package com.hero.designpatten.compose.v2;

/**
 * @description: FileSystemNode
 * @date: 2021/3/23 9:18
 * @author: maccura
 * @version: 1.0
 */
public abstract class FileSystemNode {
    protected String path;
    public FileSystemNode(String path) {
        this.path = path;
    }

    public abstract int countNumOfFiles();
    public abstract long countSizeOfFiles();
    public String getPath() {
        return path;
    }
}
