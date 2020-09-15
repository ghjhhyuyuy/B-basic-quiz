package com.thoughtworks.basic.controller;

import com.thoughtworks.basic.domain.Education;
import com.thoughtworks.basic.domain.User;
import com.thoughtworks.basic.exception.UserException;
import com.thoughtworks.basic.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by wzw on 2020/9/15.
 */
@RestController
@RequestMapping("users")
@CrossOrigin
public class UserController {
    private final UserService userService;

    public UserController() {
        this.userService = new UserService();
    }

    @GetMapping("{id}")
    public User getUser(@PathVariable long id) throws UserException {
        return userService.getUser(id);
    }

    @GetMapping("{id}/educations")
    public List<Education> getEducations(@PathVariable long id) throws UserException {
        return userService.getEducations(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody @Valid User user) {
        return userService.addUser(user);
    }

    @PostMapping("{user_id}/educations")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Education> addEducation(@PathVariable("user_id") long id, @RequestBody @Valid Education education) throws UserException {
        education.setUserId(id);
        return userService.addEducation(education);
    }
}
