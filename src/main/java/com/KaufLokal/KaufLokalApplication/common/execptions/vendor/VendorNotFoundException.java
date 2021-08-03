package com.KaufLokal.KaufLokalApplication.common.execptions.vendor;

public class VendorNotFoundException extends RuntimeException {

    public VendorNotFoundException(String message){
        super(message);
    }
}
