package com.blackfat.java8;

import java.util.concurrent.CompletableFuture;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/3/22-14:46
 */
public interface AsyncService {

    String sayHello(String name);

    default CompletableFuture<String> sayHelloAsync(String name){
        return CompletableFuture.completedFuture(sayHello(name));
    }

}
