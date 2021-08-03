package com.KaufLokal.KaufLokalApplication.common.execptions.rating;

public class RatingIsEmptyException extends RuntimeException {

    public RatingIsEmptyException(String message){
        super(message);
    }
}
