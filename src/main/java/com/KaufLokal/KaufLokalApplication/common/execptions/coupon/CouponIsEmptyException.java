package com.KaufLokal.KaufLokalApplication.common.execptions.coupon;

public class CouponIsEmptyException extends RuntimeException {

    public CouponIsEmptyException(String message){
        super(message);
    }
}
