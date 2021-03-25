package com.hero.designpatten.compose.v2;

/**
 * @description: Demo
 * @date: 2021/3/23 9:25
 * @author: maccura
 * @version: 1.0
 */
public class Demo {
    public static void main(String[] args) {
        Directory fileSystemTree = new Directory("/");
        Directory node_wz = new Directory("/wz/");
        Directory node_xzg = new Directory("/xzg/");
        fileSystemTree.addSubNode(node_wz);
        fileSystemTree.addSubNode(node_xzg);
        File node_wz_a = new File("/wz/a.txt");
        File node_wz_b = new File("/wz/b.txt");
        Directory node_wz_movies = new Directory("/wz/movies/");
        node_wz.addSubNode(node_wz_a);
        node_wz.addSubNode(node_wz_b);
        node_wz.addSubNode(node_wz_movies);
        File node_wz_movies_c = new File("/wz/movies/c.avi");
        node_wz_movies.addSubNode(node_wz_movies_c);
        Directory node_xzg_docs = new Directory("/xzg/docs/");
        node_xzg.addSubNode(node_xzg_docs);
        File node_xzg_docs_d = new File("/xzg/docs/d.txt");
        node_xzg_docs.addSubNode(node_xzg_docs_d);
        System.out.println("/ files num:" + fileSystemTree.countNumOfFiles());
        System.out.println("/wz/ files num:" + node_wz.countNumOfFiles());
    }
}
