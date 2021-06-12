package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name;
    private String description;
    private Integer price;
}
