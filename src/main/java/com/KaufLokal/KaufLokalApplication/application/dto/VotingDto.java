package com.KaufLokal.KaufLokalApplication.application.dto;

import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class VotingDto {
    private UUID id;
    private String title;
    private Set<VotingOptionDto> votingOptions;
}
