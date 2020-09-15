package com.thoughtworks.basic.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wzw on 2020/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Education {
    private long id;
    private String title;
    private long year;
    private String description;
}
