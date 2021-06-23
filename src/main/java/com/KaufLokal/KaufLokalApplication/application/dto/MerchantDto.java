package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.Address;
import com.KaufLokal.KaufLokalApplication.domain.model.Coupon;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class MerchantDto {
    private UUID id;
    private String name;
    private String company;
    private Integer offerAmount;
    private Integer merchantScore;
    private String profilePicture;
    private Address address;
    private String emailAddress;
    private Set<Coupon> coupons;
}
