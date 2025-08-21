package com.devarinti.user_demo.Exceptions;

public class CustomerExistException extends RuntimeException{
    public CustomerExistException(String message){
        super(message);
    }
}
