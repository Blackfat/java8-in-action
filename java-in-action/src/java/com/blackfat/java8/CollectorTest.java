package com.blackfat.java8;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.*;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/5/5-9:13
 */
public class CollectorTest {

    public static List<Dish>  list;

    @Before
    public void init(){
        list = Lists.newArrayList();
        list.add(new Dish("meat",false,700, Dish.Type.MEAT));
        list.add(new Dish("fish",false,400, Dish.Type.FISH));
        list.add(new Dish("other",true,800, Dish.Type.OTHER));
    }

    @Test
    public void groupbyTest(){
        Map<Dish.Type, List<Dish>> map = list.stream().collect(groupingBy(Dish::getType));
        System.out.println(map.toString());
    }

    @Test
    public void groupbyTest1(){
        Map<Dish.CaloricLevel, List<Dish>> map = list.stream().collect(groupingBy(
                dish ->{
                   if(dish.getCalories() <= 400){
                       return Dish.CaloricLevel.DIET;
                   }else if(dish.getCalories() <= 700){
                       return Dish.CaloricLevel.NORMAL;
                   }else{
                       return Dish.CaloricLevel.FAT;
                   }
                }
        ));
        System.out.println(map.toString());
    }

    @Test
    public void groupbyTest2(){
        Map<Dish.Type,Long>  map = list.stream().collect(groupingBy(Dish::getType, counting()));
        System.out.println(map);
    }

    @Test
    public void partitioningByTest(){
        Map<Boolean, List<Dish>> map = list.stream().collect(partitioningBy(Dish::isVegetarian));
        System.out.println(map);
    }



    @Test
    public void reduceTest() {
        int totalCalories = list.stream().collect(reducing(
                0, Dish::getCalories, (i, j) -> i + j
        ));
        System.out.println(totalCalories);
    }






}
