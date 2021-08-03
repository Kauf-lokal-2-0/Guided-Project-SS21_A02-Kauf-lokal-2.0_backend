package com.KaufLokal.KaufLokalApplication.common.execptions.rating;

public class RatingNotFoundException extends RuntimeException {

    public RatingNotFoundException(String message){
        super(message);
    }
}
