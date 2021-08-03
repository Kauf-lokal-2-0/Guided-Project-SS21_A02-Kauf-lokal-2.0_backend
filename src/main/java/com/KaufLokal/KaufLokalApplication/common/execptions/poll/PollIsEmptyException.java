package com.KaufLokal.KaufLokalApplication.common.execptions.poll;

public class PollIsEmptyException extends RuntimeException {

    public PollIsEmptyException(String message){
        super(message);
    }
}
