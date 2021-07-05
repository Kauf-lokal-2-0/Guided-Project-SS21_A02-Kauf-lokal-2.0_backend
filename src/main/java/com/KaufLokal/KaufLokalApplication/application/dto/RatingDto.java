package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class RatingDto {
    private UUID id;
    private Double ratingScore;
}
