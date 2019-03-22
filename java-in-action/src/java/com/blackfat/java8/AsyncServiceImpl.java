package com.blackfat.java8;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/3/22-14:52
 */
public class AsyncServiceImpl implements  AsyncService {

    @Override
    public String sayHello(String name) {
        return name;
    }





    public static void main(String[] args) {
        AsyncServiceImpl asyncService = new AsyncServiceImpl();
        CompletableFuture<String> future = asyncService.sayHelloAsync("hello world");
        future.whenComplete((result, exception) ->{
            if(exception == null){
                System.out.println(result);
            }else{
                exception.printStackTrace();
            }
        });
    }



}
