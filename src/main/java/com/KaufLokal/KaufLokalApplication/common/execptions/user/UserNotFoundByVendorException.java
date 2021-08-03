package com.KaufLokal.KaufLokalApplication.common.execptions.user;

public class UserNotFoundByVendorException extends RuntimeException {

    public UserNotFoundByVendorException(String message){
        super(message);
    }
}
