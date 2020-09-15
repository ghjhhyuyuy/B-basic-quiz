package com.thoughtworks.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by wzw on 2020/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private long userId;
    @Length(min = 1,max = 256)
    @NotNull
    private String title;
    @NotNull
    private long year;
    @Length(min = 1,max = 4096)
    @NotNull
    private String description;
}
