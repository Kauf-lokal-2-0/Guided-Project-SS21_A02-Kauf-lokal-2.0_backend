package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.Address;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import com.KaufLokal.KaufLokalApplication.domain.model.Rating;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer userScore;
    private String profilePicture;
    private Address address;
    private Set<Rating> ratings;
    private Set<Merchant> favoriteMerchants;
}
