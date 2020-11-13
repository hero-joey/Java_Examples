package com.hero.stream;

import jdk.nashorn.internal.runtime.options.Option;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @description: StreamOperation
 * @date: 2020/11/11
 * @author: bear
 * @version: 1.0
 */
public class StreamOperation {
    public static void test1() {
        //延迟计算，没有遇到终止操作，不会输出
//        Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        });

//        //延迟计算，打印输出
//        Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        }).forEach(System.out::println);

        //求和
//       int sum = Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        }).mapToInt(x -> x).sum();
//        System.out.println(sum);

        //求最小值
//        int max = Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        }).max(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o1 - o2;
//            }
//        }).get();
//        System.out.println(max);

        //求个数
//        long count  = Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        }).count();
//        System.out.println(count);
        // 查找第一个
//        Optional<Integer> element = Arrays.asList(1,2,3,4,5,6).stream().filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(Integer integer) {
//                //System.out.println(integer);
//                return integer % 2 == 0;
//            }
//        }).findFirst();
//        System.out.println(element.get());

        // 排序
        //Arrays.asList(1,2,3,4,5,6).stream().sorted().forEach(System.out::println);
//        Arrays.asList(1,2,3,4,5,6).stream().sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).forEach(System.out::println);

        //转换成list
//        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1);
//        List<Integer> integerList = integerStream.limit(50).filter(x -> x % 2 == 0).collect(Collectors.toList());
//        integerList.stream().forEach(System.out::println);

        //去重
        //Arrays.asList(1, 3, 10, 25, 10, 25, 45, 3).stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
        //Arrays.asList(1, 3, 10, 25, 10, 25, 45, 3).stream().collect(Collectors.toSet()).forEach(System.out::println);

        //实现分页功能
//        Stream<Integer> integerStream = Stream.iterate(1, x -> x + 1);
//        integerStream.limit(50).sorted(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        }).skip(20).limit(10).collect(Collectors.toList()).forEach(System.out::println);


        String str = "11,22,33,44,55";
        int sum = Arrays.stream(str.split(",")).mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

    }

    public static void main(String[] args) {
        //test1();
        test2();
    }

    private static void test2() {
        String str = "tomcat,netty,rocketmq";
        Stream.of(str.split(",")).map(x -> new User(x)).forEach(System.out::println);
        Stream.of(str.split(",")).map(User::new).forEach(System.out::println);

        str = "11,22,33,44,55";
        int sum = Arrays.stream(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum();
        System.out.println(sum);

    }
}

class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                '}';
    }
}
