package com.hero.designpatten.strategy.sort.v3;

import com.hero.designpatten.strategy.sort.v2.*;

import java.io.File;

/**
 * @description: Sorter
 * @date: 2021/3/12 11:45
 * @author: maccura
 * @version: 1.0
 */
public class Sorter {
    private static final long GB = 1000 * 1000 * 1000;

    public void sortFile(String filePath) {
        // 省略校验逻辑
        File file = new File(filePath);
        long fileSize = file.length();
        ISortAlg sortAlg;
        if (fileSize < 6 * GB) { // [0, 6GB)
            sortAlg = SortAlgFactory.getSortAlg("QuickSort");
        } else if (fileSize < 10 * GB) { // [6GB, 10GB)
            sortAlg = SortAlgFactory.getSortAlg("ExternalSort");
        } else if (fileSize < 100 * GB) { // [10GB, 100GB)
            sortAlg = SortAlgFactory.getSortAlg("ConcurrentExternalSort");
        } else { // [100GB, ~)
            sortAlg = SortAlgFactory.getSortAlg("MapReduceSort");
        }

        sortAlg.sort(filePath);
    }
}
