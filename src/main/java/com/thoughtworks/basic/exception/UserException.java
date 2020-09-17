package com.thoughtworks.basic.exception;

/**
 * Created by wzw on 2020/9/15.
 */
// GTB: 自定义异常通常从 RuntimeException 继承
// GTB: - UserException 命名不好，太泛
public class UserException extends Throwable {
    String meg;
    public UserException(String msg){
        this.meg = "[User error]" + msg;
    }

    public String getMeg() {
        return meg;
    }
}
