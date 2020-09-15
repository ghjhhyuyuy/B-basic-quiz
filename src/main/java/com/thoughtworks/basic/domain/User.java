package com.thoughtworks.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by wzw on 2020/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    @NotNull
    @Length(min = 1,max = 128)
    private String name;
    @Min(17)
    @NotNull
    private long age;
    @Length(min = 8,max = 512)
    @NotNull
    private String avatar;
    @Length(max = 1024)
    private String description;
}
