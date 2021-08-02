package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class PollOptionDto {
    private UUID id;
    private String title;
    private int totalAmountVoters;
    private Set<UUID> users;
}
