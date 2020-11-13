package com.hero.lambda;

import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Main {


    static int get() {
        System.out.println("get");
        return 1;
    }

    static void exec() {
        System.out.println("exec");;
    }

    static String find() {
        return "hello";
    }

    static Integer orderTest1(Order order) {
        System.out.println("order test1");
        return 1;
    }

    static void orderTest2(Order order) {
        System.out.println("orderTest2");
    }

    public static void main(String[] args) throws Exception {
	// write your code here
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable1");
            }
        };
        runnable1.run();

        Runnable runnable2 = () -> System.out.println("runnable2");
        runnable2.run();

        Runnable runnable3 = () -> {
            System.out.println("Runnable3");
        };
        runnable3.run();

        Callable<String> callable = () -> "hello";
        System.out.println(callable.call());

        UserMapper userMapper = new UserMapper() {
            @Override
            public void insertUser(User user) {
                System.out.println(user);
            }
        };

        UserMapper userMapper1 = System.out::println;
        userMapper.insertUser(new User());

        UserMapper userMapper2= (user) -> System.out.println(user);
        userMapper2.insertUser(new User());

        OrderMapper orderMapper = new OrderMapper() {
            @Override
            public int insertOrder(Order order) {
                return 0;
            }
        };

        OrderMapper orderMapper1 = (user) -> 1;
        System.out.println(orderMapper.insertOrder(new Order()));

        OrderMapper orderMapper2 = (user) -> {return 1;};
        System.out.println(orderMapper2.insertOrder(new Order()));

        Function<Integer, Integer> function = x -> {
            int sum = 0;
            for (int i = 0; i < x; i++) {
                sum += i;
            }
            return  sum;
        };
        System.out.println(function.apply(10));

        Runnable runnable = () -> get();
        runnable.run();

        Runnable runnable4 = () -> exec();
        runnable4.run();

        Runnable runnable5 = () -> find();
        runnable5.run();

        //不可以这样使用，否则会报错
        //Runnable runnable6 = () -> 100;

        OrderMapper orderMapper3 = x -> orderTest1(x);
        //OrderMapper orderMapper4 = x -> orderTest2(x);

        BiFunction<String, String, Integer> biFunction = (s1, s2) -> Integer.parseInt(s1) + Integer.parseInt(s2);
        System.out.println(biFunction.apply("123", "456"));



    }
}

@FunctionalInterface
interface UserMapper {
    void insertUser(User user);
}

@FunctionalInterface
interface OrderMapper {
    int insertOrder(Order order);
}

class User {

}

class Order {

}
