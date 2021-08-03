package com.KaufLokal.KaufLokalApplication.domain.model.embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {
    private String street;
    private String houseNr;
    private String place;
    private String zipCode;
    private String country;
}
