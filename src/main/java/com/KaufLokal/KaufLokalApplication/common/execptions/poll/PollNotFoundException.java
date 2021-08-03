package com.KaufLokal.KaufLokalApplication.common.execptions.poll;

public class PollNotFoundException extends RuntimeException {

    public PollNotFoundException(String message){
        super(message);
    }
}
