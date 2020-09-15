package com.thoughtworks.basic.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wzw on 2020/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @JsonIgnore
    private long id;
    private String name;
    private long age;
    private String avatar;
    private String description;
}
