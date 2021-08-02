package com.KaufLokal.KaufLokalApplication.common.execptions.event;

public class EventIsEmptyException extends RuntimeException {

    public EventIsEmptyException(String message){
        super(message);
    }
}
