package com.hero.designpatten.strategy.sort.v1;

/**
 * @description: SortingTool
 * @date: 2021/3/12 11:42
 * @author: maccura
 * @version: 1.0
 */
public class SortingTool {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        sorter.sortFile(args[0]);
    }
}
