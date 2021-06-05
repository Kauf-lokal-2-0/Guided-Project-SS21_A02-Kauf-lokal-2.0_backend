package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MerchantDto {
    private UUID id;
    private String name;
    private String company;
    private Integer offerAmount;
    private Integer merchantScore;

    private String street;
    private String houseNr;
    private String place;
    private String zipCode;
    private String country;


}
