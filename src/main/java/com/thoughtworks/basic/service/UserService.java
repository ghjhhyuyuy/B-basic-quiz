package com.thoughtworks.basic.service;

import com.thoughtworks.basic.domain.User;
import com.thoughtworks.basic.exception.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wzw on 2020/9/15.
 */
public class UserService {
    private final List<User> userList = new ArrayList<>();
    private int index = 0;
    public UserService(){
        index++;
        User user = new User();
        user.setAge(24);
        user.setAvatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0");
        user.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.");
        user.setName("KAMIL");
        user.setId(index);
        userList.add(user);
    }
    public User getUser(int id) throws UserException {
        try{
            return userList.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
        }catch (Exception e){
            throw new UserException("id错误");
        }
    }
}
