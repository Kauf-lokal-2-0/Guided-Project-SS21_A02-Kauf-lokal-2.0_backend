package com.KaufLokal.KaufLokalApplication.common.execptions.vendor;

public class VendorIsEmptyException extends RuntimeException {

    public VendorIsEmptyException(String message){
        super(message);
    }
}
