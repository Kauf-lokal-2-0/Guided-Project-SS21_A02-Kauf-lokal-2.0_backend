package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "OFFER")
@Data
public class Offer {

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
    private String description;

    private Integer starRatingAmount;

    @ElementCollection
    private List<String> images = new ArrayList<>();

    private Boolean isFavourite;

    private String category;

    @OneToMany
    private Set<Product> products = new HashSet<>(); // Products which may be displayed in an offer

    @OneToMany
    private Set<Coupon> coupons = new HashSet<>(); // Coupons, which belongs to an offer
}
