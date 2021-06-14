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
}
