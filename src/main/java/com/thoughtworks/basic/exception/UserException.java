package com.thoughtworks.basic.exception;

/**
 * Created by wzw on 2020/9/15.
 */
public class UserException extends Throwable {
    String meg;
    public UserException(String msg){
        this.meg = "[User error]" + msg;
    }

    public String getMeg() {
        return meg;
    }
}
