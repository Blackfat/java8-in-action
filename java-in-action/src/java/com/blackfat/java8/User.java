package com.blackfat.java8;


import com.google.common.collect.ImmutableList;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author wangfeiyang
 * @desc
 * @create 2019/3/27-11:21
 */
@Data
@Accessors(chain=true)
@NoArgsConstructor(staticName = "of")
public class User {

    private String username;

    private Integer age;


    public static void main(String[] args) {
        List<User> list = ImmutableList.of(User.of().setAge(22).setUsername("james"));
        Map<String, List<Integer>> map = list.stream().collect(Collectors.groupingBy(User::getUsername,
                Collectors.mapping(User::getAge, Collectors.toList())));
    }

}
