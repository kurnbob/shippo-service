package com.mandiri.shippoapps.utils;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String errMessage){
        super(errMessage);
    }
}
