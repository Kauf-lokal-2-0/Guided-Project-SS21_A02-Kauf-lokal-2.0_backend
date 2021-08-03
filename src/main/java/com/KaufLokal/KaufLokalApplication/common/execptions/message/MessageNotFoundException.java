package com.KaufLokal.KaufLokalApplication.common.execptions.message;

public class MessageNotFoundException extends RuntimeException {

    public MessageNotFoundException(String message){
        super(message);
    }
}
