package com.KaufLokal.KaufLokalApplication.common.execptions.event;

public class EventNotFoundByVendorException extends RuntimeException {

    public EventNotFoundByVendorException(String message){
        super(message);
    }
}
