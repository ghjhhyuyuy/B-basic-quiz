package com.thoughtworks.basic.controller;

import com.thoughtworks.basic.domain.User;
import com.thoughtworks.basic.exception.UserException;
import com.thoughtworks.basic.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wzw on 2020/9/15.
 */
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;
    public UserController(){
        this.userService = new UserService();
    }
    @GetMapping("{id}")
    public User getUser(@PathVariable int id) throws UserException {
        return userService.getUser(id);
    }
}
