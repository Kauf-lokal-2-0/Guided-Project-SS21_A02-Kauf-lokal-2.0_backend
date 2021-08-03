package com.KaufLokal.KaufLokalApplication.common.execptions.user;

public class UserNotFoundByCouponException extends RuntimeException {

    public UserNotFoundByCouponException(String message){
        super(message);
    }
}
