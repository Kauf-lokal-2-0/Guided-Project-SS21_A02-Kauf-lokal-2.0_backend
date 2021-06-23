package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
public class OfferDto {

    private UUID id;
    private String name;
    private String description;
    private Boolean isStoreOpened;
    private Boolean isFavourite;
    private String category;
    private Integer starRatingAmount;
    private List<String> images;
}


