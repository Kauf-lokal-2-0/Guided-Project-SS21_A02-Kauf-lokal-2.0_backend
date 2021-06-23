package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.Address;
import lombok.Data;

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
}
