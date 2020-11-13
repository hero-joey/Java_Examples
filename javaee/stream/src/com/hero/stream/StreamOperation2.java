package com.hero.stream;

import javax.swing.text.html.Option;
import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * @description: StreamOperation
 * @date: 2020/11/11
 * @author: bear
 * @version: 1.0
 */
public class StreamOperation2 {

    public static void main(String[] args) {

        //parallel用于将函数变成并行流，与位置无关，因为流是延迟计算
        //sequential用于将函数变成串行流
        //取决于谁在后面
        //parallelism可以设置并行数
        //ForkJoinPool.commonPool();
        //-Djava.util.concurrent.ForkJoinPool.common.parallelism=5设置并行数
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");


        Optional<Integer> integerStream = Stream.iterate(1, x -> x + 1).limit(200).sequential().parallel().peek(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(Thread.currentThread().getName());
            }
        }).max(Integer::compareTo);
        System.out.println(integerStream.get());

    }
}

