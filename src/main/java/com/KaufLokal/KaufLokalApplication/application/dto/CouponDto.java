package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class CouponDto {
    private UUID id;
    private String couponName;
    private String couponDescription;
    private Integer generatedCouponCode;
    private String expiryDate;
    private Float value;
    private Boolean isFavourite;
}
