package com.KaufLokal.KaufLokalApplication.common.execptions.user;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message){
        super(message);
    }
}
