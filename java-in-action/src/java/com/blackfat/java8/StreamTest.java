package com.blackfat.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/6/1-13:44
 */
public class StreamTest {


    @Test
    public void stream1(){
        List<String> all=new ArrayList<String>();
        all.add("android");
        all.add("java");
        all.add("c++");
        Stream<String> stream = all.stream();
        System.out.println(stream.count());
    }

    @Test
    public void stream2(){
        Stream<String> stream = Stream.of("a","b","c");
        stream.forEach(System.out::println);
    }


    @Test
    public void stream3(){
        List<String> myList =
                Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("c");
                })
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);})
                .map(s ->{
                    System.out.println("map:"+s);
                    return s.toUpperCase();}
                )
                .forEach(System.out::println);





    }


    @Test
    public void stream4(){
        //衔接操作只在终止操作调用时被执行
        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                }) .forEach(s -> System.out.println("forEach: " + s));;
    }


    @Test
    public void stream5(){
        List<String> words = Arrays.asList("java8","lambada","action");

        List<String> list = words.stream().map(w -> w.split(""))
                       // 可以将单个流内容合并起来扁平化成一个流
                      .flatMap(Arrays::stream)
                      .distinct()
                      .collect(Collectors.toList());

        for(Object o: list){
            System.out.print(o);
        }

    }






}
