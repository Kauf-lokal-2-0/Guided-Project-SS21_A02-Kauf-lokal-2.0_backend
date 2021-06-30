package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
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

    @Column(nullable = false)
    private String company;

    private Integer merchantScore;

    private Address address;

    private String profilePicture;

    private String emailAddress;

    private OpeningTime openingTime;

    @OneToMany
    private Set<Coupon> coupons = new HashSet<>();

    @OneToMany
    private Set<Rating> ratings = new HashSet<>();

    @OneToMany
    private Set<Product> products = new HashSet<>();

    @OneToMany
    private Set<Newsfeed> newsfeeds = new HashSet<>();

}
