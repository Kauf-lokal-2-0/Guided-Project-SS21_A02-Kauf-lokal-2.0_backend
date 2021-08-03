package com.KaufLokal.KaufLokalApplication.common.execptions.user;

public class UserIsEmptyException extends RuntimeException {

    public UserIsEmptyException(String message){
        super(message);
    }
}
