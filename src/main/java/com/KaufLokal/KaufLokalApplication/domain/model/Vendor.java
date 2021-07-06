package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "MERCHANT")
@Data
public class Vendor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private Integer merchantScore;

    private Address address;

    private String profilePicture;

    private String emailAddress;

    private OpeningTime openingTime;

    private String websiteURL;

    private String color;

    private VendorCategory category;

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

    public Vendor() {
    }

    public Vendor(String name, Integer merchantScore, Address address, String profilePicture, String emailAddress, OpeningTime openingTime, String websiteURL, String color, VendorCategory category, Set<Coupon> coupons, Set<Rating> ratings, Set<Product> products, Set<Message> messages, Set<Event> events) {
        this.name = name;
        this.merchantScore = merchantScore;
        this.address = address;
        this.profilePicture = profilePicture;
        this.emailAddress = emailAddress;
        this.openingTime = openingTime;
        this.websiteURL = websiteURL;
        this.color = color;
        this.category = category;
        this.coupons = coupons;
        this.ratings = ratings;
        this.products = products;
        this.messages = messages;
        this.events = events;
    }
}
