package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class CouponDto {
    private UUID id;
    private String name;
    private String description;
    private Integer couponCode;
    private Date expiryDate;
    private Float value;
    private Date created;
    private UUID vendorId;
}
