package com.amir.Diploma.exceptions;

public class UserAlreadyExistException extends RuntimeException{
    public UserAlreadyExistException(String s){
        super(s);
    }
}
