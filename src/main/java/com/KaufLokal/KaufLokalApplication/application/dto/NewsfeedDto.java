package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class NewsfeedDto {
    private UUID id;
    private String message;
}
