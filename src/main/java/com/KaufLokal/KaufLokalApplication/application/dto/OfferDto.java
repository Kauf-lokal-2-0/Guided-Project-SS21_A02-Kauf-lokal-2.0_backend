package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.UUID;

@Data
public class OfferDto {

    private UUID id;
    private String offerName;
    private String offerDescription;
    private String offerCreatedDate;
    private String offerLastUpdate;
    private Integer likeAmount;
    private Integer shareAmount;
}


