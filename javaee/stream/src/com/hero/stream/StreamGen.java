package com.hero.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
/**
 * @description:
 * Stream.generate  会一直输出流，需要限制长度
 * Stream.iterate
 * @param:
 * @return:
 * @auther: bear
 * @date: 2020/11/11
 */
public class StreamGen {
    static void genStreamFromArray() {
        String[] arr = {"1", "2", "1", "2"};
        Stream<String> stringStream = Stream.of(arr);
    }

    static void genStreamFromLis() {
        String[] arr = {"1", "2", "1", "2"};
        Stream<String> stringStream = Arrays.asList(arr).stream();
    }

    static void genStreamFromFunction() {
        Stream<Integer> integerStream = Stream.generate(()->1);
        integerStream.limit(10).forEach(System.out::println);
    }

    static void genStreamFromIterator() {
        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1);
        integerStream.limit(10).forEach(System.out::println);
    }

    static void genStreamFromIntStream() {
        String str = "abcd1223";
        IntStream intStream = str.chars();
        intStream.forEach(x -> System.out.println(x));
        intStream.forEach(System.out::println);
    }
    static void genStreamFromFileStream() {
        try {
            Files.lines(Paths.get("d://log.txt")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	// write your code here
       // genStreamFromIntStream();
        //genStreamFromFileStream();
        //genStreamFromFunction();
        genStreamFromIterator();
    }
}
