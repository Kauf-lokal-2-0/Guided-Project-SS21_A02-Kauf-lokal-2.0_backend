package com.KaufLokal.KaufLokalApplication.common.execptions.message;

public class MessageIsEmptyException extends RuntimeException {

    public MessageIsEmptyException(String message){
        super(message);
    }
}
