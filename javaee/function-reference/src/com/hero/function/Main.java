package com.hero.function;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    public static String getMessage() {
        System.out.println("hello, get message!");
        return "message";
    }

    public static void printInteger(Integer x) {
        System.out.println(x);
    }

    public String put() {
        return "hello";
    }

    public static void main(String[] args) {
        Function<String, String> function = (string) -> string.toUpperCase();
        System.out.println(function.apply("admin"));

        Consumer<String> consumer = (string) -> System.out.println(string);
        consumer.accept("hello");

        //Supplier<String> supplier = () -> "hello";
        Supplier<String> supplier = () -> getMessage();
        System.out.println(supplier.get());

        //静态方法引用
        Supplier<String> supplier1 = Main::getMessage;
        supplier1.get();

        Consumer<Integer> consumer1 = Main::printInteger;
        consumer1.accept(10);

        Function<String, String> function2 = (string) -> string.toUpperCase();

        Supplier<String> supplier2 = new Main()::put;
        System.out.println(supplier2.get());

        // write your code here
    }
}
