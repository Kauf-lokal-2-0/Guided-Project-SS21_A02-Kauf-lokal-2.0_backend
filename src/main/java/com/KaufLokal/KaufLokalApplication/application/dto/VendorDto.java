package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.*;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class VendorDto {
    private UUID id;
    private String name;
    private Integer offerAmount;
    private Integer vendorScore;
    private String logo;
    private String websiteURL;
    private String color;
    private VendorCategory category;
    private Address address;
    private String emailAddress;
    private OpeningTime openingTime;
    private Set<String> detailImages;
    private Set<Coupon> coupons;
    private Set<Rating> ratings;
    private Set<Product> products;
    private Set<Message> messages;
    private Set<Event> events;
}
