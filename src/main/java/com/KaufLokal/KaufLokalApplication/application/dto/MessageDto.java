package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class MessageDto {
    private UUID id;
    private String title;
    private String message;
    private String imageURL;
    private UUID vendorId;
    private Date created;
}
