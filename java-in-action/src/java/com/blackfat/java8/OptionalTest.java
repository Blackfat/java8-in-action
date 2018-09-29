package com.blackfat.java8;

import org.junit.Test;

import java.util.Optional;

/**
 * @author wangfeiyang
 * @desc
 * @create 2018/9/29-9:58
 */
public class OptionalTest
{

    @Test
    public void optional1(){
        Optional<Car> optCar = Optional.empty();
        System.out.println(optCar.isPresent());

        Insunrance insunrance = new Insunrance();
        insunrance.setName("insunrance");
        Optional<Insunrance> optInsunrance = Optional.ofNullable(insunrance);
        System.out.println(optInsunrance.isPresent());
    }

    @Test
    public void optional2(){
        Insunrance insunrance = new Insunrance();
        insunrance.setName("insunrance");
//        Insunrance insunrance = null;
        Optional<Insunrance> optInsunrance = Optional.ofNullable(insunrance);
        Optional<String> name = optInsunrance.map(Insunrance::getName);
        // 如果值存在则直接返回，否则返回默认值
        System.out.println(name.orElse("UnKnown"));
    }

    @Test
    public void optional3(){
        Person person = null;
        Optional<Person> optperson = Optional.ofNullable(person);
        Optional<String> name = optperson.flatMap(Person::getCar)
                                         .flatMap(Car::getInsurance)
                                         .map(Insunrance::getName);
        System.out.println(name.orElse("UnKnown"));

    }

}
class Person{
    // 人可能有车，也可能没车
    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
class Car{
    // 车可能进行了保险也可能没有保险
    private Optional<Insunrance> insurance;

    public Optional<Insunrance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insunrance> insurance) {
        this.insurance = insurance;
    }
}
class Insunrance{
    // 保险公司必须有名字
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
