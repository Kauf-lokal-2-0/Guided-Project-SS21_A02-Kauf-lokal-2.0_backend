package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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

    private String createdDate;

    private String lastUpdate;

    private Integer likeAmount;

    private Integer shareAmount;

    @OneToMany
    private Set<Product> products = new HashSet<>();

    @OneToMany
    private Set<Coupon> coupons = new HashSet<>();
}
