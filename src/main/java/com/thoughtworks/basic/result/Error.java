package com.thoughtworks.basic.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wzw on 2020/9/15.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Error {
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
}
