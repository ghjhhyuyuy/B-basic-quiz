package com.thoughtworks.basic.service;

import com.thoughtworks.basic.domain.Education;
import com.thoughtworks.basic.domain.User;
import com.thoughtworks.basic.exception.UserException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by wzw on 2020/9/15.
 */
public class UserService {
    // GTB: - 提取 Repository，具体可以跟小组同学交流一下
    private final List<User> userList = new ArrayList<>();
    private final List<List<Education>> educationList = new ArrayList<>();
    private int index = 0;

    public UserService() {
        // GTB: 直接 index 从 1 开始就省得++了
        index++;
        initUser();
        initEducation();
    }

    private void initEducation() {
        List<Education> educations = new ArrayList<>();
        Education education = new Education();
        education.setDescription("Eos, explicabo, nam, tenetur et ab eius deserunt aspernatur ipsum ducimus quibusdam quis voluptatibus.");
        education.setUserId(index);
        education.setTitle("Secondary school specializing in artistic");
        education.setYear(2005);
        educations.add(education);
        educationList.add(educations);
    }

    public User getUser(long id) throws UserException {
        // GTB: - 不要用这种方式判断用户是否存在！再详细了解一下 Stream API
        try {
            return userList.stream().filter(user -> user.getId() == id).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            throw new UserException("id错误");
        }
    }

    public List<Education> getEducations(long id) throws UserException {
        // GTB: - 不要用这种方式判断用户是否存在！再详细了解一下 Stream API
        try {
            return educationList.stream().filter(education -> education.get(0).getUserId() == id).collect(Collectors.toList()).get(0);
        } catch (Exception e) {
            throw new UserException("id错误");
        }
    }

    public User addUser(User user) {
        // GTB: - 生成 id 可以用 AtomicLong，避免一定的并发问题
        user.setId(++index);
        userList.add(user);
        return user;
    }

    public List<Education> addEducation(Education education) throws UserException {
        try {
            List<Education> educations = educationList.stream().filter(theEducation -> theEducation.get(0).getUserId() == education.getUserId()).collect(Collectors.toList()).get(0);
            educations.add(education);
            int index = educationList.indexOf(educations);
            educationList.set(index, educations);
            return educations;
        } catch (Exception e) {
            throw new UserException("添加错误，请检查用户id");
        }
    }

    public void initUser(){
        User user = new User();
        user.setAge(24);
        user.setAvatar("https://inews.gtimg.com/newsapp_match/0/3581582328/0");
        user.setDescription("Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi.");
        user.setName("KAMIL");
        user.setId(index);
        userList.add(user);
    }
}
