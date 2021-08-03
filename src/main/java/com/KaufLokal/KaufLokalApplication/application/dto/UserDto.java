package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.embeddable.Address;
import com.KaufLokal.KaufLokalApplication.domain.model.Experience;
import com.KaufLokal.KaufLokalApplication.domain.model.Rating;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private Integer level;
    private Integer experience;
    private String firstName;
    private String lastName;
    private String email;
    private Address address;
    private Set<Rating> ratings;
    private Set<UUID> favoriteVendorsIDs = new HashSet<>();
    private Set<UUID> favoriteCouponIDs = new HashSet<>();
    private Set<Experience> experiences;
}
