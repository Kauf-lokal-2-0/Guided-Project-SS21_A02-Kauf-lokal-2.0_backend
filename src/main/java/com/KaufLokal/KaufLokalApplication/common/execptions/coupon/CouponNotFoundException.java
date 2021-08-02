package com.KaufLokal.KaufLokalApplication.common.execptions.coupon;

public class CouponNotFoundException extends RuntimeException {

    public CouponNotFoundException (String message){
        super(message);
    }
}
