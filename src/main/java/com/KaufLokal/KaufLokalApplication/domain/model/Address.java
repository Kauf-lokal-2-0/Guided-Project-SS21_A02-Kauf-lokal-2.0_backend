package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import javax.persistence.*;

@Data
@Embeddable
public class Address {

    private String street;
    private String houseNr;
    private String place;
    private String zipCode;
    private String country;

    public Address() {
    }

    public Address(String street, String houseNr, String place, String zipCode, String country) {
        this.street = street;
        this.houseNr = houseNr;
        this.place = place;
        this.zipCode = zipCode;
        this.country = country;
    }
}
