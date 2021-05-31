package com.KaufLokal.KaufLokalApplication.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.UUID;

@Entity
public class Trader {

    @Type(type= "uuid-char")
    @GeneratedValue(generator = "SuperEntityUuidGenerator")
    @GenericGenerator(name = "SuperEntityUuidGenerator", strategy = "com.evatool.requirements.domain.entity.SuperEntityUuidGenerator")
    private String id;


    public UUID getId() {
        return id;
    }
}
