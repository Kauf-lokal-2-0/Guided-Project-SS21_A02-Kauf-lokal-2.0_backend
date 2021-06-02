package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.awt.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@Table(name = "MERCHANT")
@Data
public class Merchant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column
    private String company;

    @Column
    private Integer offerAmount;

    @Column
    private Integer merchantScore;

    @OneToMany
    private Collection<Address> address;

}
