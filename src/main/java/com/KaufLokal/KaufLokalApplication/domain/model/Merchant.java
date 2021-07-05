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

    private String websiteURL;

    private String color;

    private MerchantCategory category;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Coupon> coupons;

    @OneToMany
    private Set<Rating> ratings;

    @OneToMany
    private Set<Product> products;

    @OneToMany
    private Set<Message> messages;

    @OneToMany
    private Set<Event> events;

}
