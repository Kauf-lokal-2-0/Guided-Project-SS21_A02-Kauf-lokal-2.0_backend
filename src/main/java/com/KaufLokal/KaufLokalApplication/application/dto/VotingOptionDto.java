package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.User;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class VotingOptionDto {
    private UUID id;
    private String title;
    private int totalAmountVoters;
    private Set<UUID> users;
}
