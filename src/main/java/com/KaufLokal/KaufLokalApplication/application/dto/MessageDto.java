package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class MessageDto {
    private UUID id;
    private String message;
    private Date created;
}
