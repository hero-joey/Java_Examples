package com.hero.designpatten.builder;

/**
 * @description: Main
 * @date: 2021/3/4 14:37
 * @author: maccura
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        try {
            ResourcePoolConfig config = new ResourcePoolConfig.Builder()
                    .setName("DbPool")
                    .setMaxTotal(16)
                    .setMaxIdle(10)
                    .setMinIdle(12)
                    .build();
        } catch (Exception ex) {
            System.out.println("Error occured: " + ex.getMessage());
        }
    }
}
