package com.ecommerce.exception;

public class InvalidOrderException extends Throwable {
    public InvalidOrderException(String message){
        super(message);
    }
}
