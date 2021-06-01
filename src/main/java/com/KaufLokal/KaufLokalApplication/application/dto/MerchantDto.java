package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.Address;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class MerchantDto {
    private UUID id;
    private String name;
    private List<Address> addresses;
}
