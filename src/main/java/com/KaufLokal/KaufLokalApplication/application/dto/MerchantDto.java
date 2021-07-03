package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.*;
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
    private String websiteURL;
    private String color;
    private MerchantCategory category;
    private Address address;
    private String emailAddress;
    private OpeningTime openingTime;
    private Set<Coupon> coupons;
    private Set<Rating> ratings;
    private Set<Product> products;
    private Set<Message> messages;
    private Set<Event> events;

}
