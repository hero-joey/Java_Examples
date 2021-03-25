package com.hero.designpatten.compose.v1;

import java.io.File;
import java.util.ArrayList;

/**
 * @description: FileSystemNode
 * @date: 2021/3/23 9:06
 * @author: maccura
 * @version: 1.0
 */
public class FileSystemNode {
    private String path;
    private boolean isFile;
    private ArrayList<FileSystemNode> subNodes = new ArrayList<>();

    public FileSystemNode(String path, boolean isFile) {
        this.path = path;
        this.isFile = isFile;
    }

    public String getPath() {
        return path;
    }

    public int countNumberOfFiles() {
        if (isFile) {
            return 1;
        }

        int numberOfFiles = 0;
        for (FileSystemNode fileSystemNode : subNodes) {
            numberOfFiles += fileSystemNode.countNumberOfFiles();
        }
        return numberOfFiles;
    }

    public Long countSizeOfFiles() {
        if (isFile) {
            File file = new File(path);
            if (!file.exists()) {
                return 0L;
            }
            return file.length();
        }

        long sizeofFiles = 0;
        for (FileSystemNode fileOrDir : subNodes) {
            sizeofFiles += fileOrDir.countSizeOfFiles();
        }

        return sizeofFiles;
    }

    public void addSubNode(FileSystemNode fileOrDir) {
        subNodes.add(fileOrDir);
    }

    public void removeSubNode(FileSystemNode fileOrDir) {
        int size = subNodes.size();
        int i = 0;
        for (; i < size; ++i) {
            if (subNodes.get(i).getPath().equalsIgnoreCase(fileOrDir.getPath())) {
                break;
            }
        }

        if (i < size) {
            subNodes.remove(i);
        }
    }
}

