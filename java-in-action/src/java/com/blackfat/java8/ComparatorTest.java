package com.blackfat.java8;

import com.google.common.base.MoreObjects;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/27-14:26
 */
public class ComparatorTest {


    @Test
    public void  comparator1(){
        List<People> peopleList = new ArrayList<People>() {{
            add(new People("A", 33));
            add(new People("B", 11));
            add(new People("C", 18));
        }};

//        peopleList.sort((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
//
//        peopleList.sort(Comparator.comparing(people -> people.getAge()));

        peopleList.sort(Comparator.comparing(People::getAge));

        for(People p: peopleList){
            System.out.println(MoreObjects.toStringHelper(p).add("name",p.getName()).add("age",p.getAge()));
        }

    }

    @Test
    public void comparator2(){
        List<People> peopleList = new ArrayList<People>() {{
            add(new People("A", 11));
            add(new People("B", 11));
            add(new People("C", 18));
        }};


        peopleList.sort(Comparator.comparing(People::getAge).thenComparing(Comparator.comparing(People::getName)).reversed());

        for(People p: peopleList){
            System.out.println(MoreObjects.toStringHelper(p).add("name",p.getName()).add("age",p.getAge()));
        }
    }



}
class People {

    private String name;
    private Integer age;

    public People(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
