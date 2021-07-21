package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "VENDOR")
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

    private Integer vendorScore;

    @Column(nullable = false)
    private Address address;

    private String logo;

    @Column(nullable = false)
    private String emailAddress;

    private OpeningTime openingTime;

    private String websiteURL;

    private String color;

    @Column(nullable = false)
    private VendorCategory category;

    @ElementCollection
    private Set<String> detailImages;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Coupon> coupons;

    @OneToMany
    private Set<Rating> ratings;

    @OneToMany
    private Set<Message> messages;

    @OneToMany
    private Set<Event> events;

    @OneToMany
    private Set<Voting> votings;


    public Vendor() {
    }

    public Vendor(String name, Integer vendorScore, Address address, String logo,
                  String emailAddress, OpeningTime openingTime, String websiteURL,
                  String color, VendorCategory category, Set<Coupon> coupons,
                  Set<Rating> ratings,  Set<Message> messages,
                  Set<Event> events, Set<String> detailImages) {
        this.name = name;
        this.vendorScore = vendorScore;
        this.address = address;
        this.logo = logo;
        this.detailImages = detailImages;
        this.emailAddress = emailAddress;
        this.openingTime = openingTime;
        this.websiteURL = websiteURL;
        this.color = color;
        this.category = category;
        this.coupons = coupons;
        this.ratings = ratings;
        this.messages = messages;
        this.events = events;
    }

    public String getName() {
        if (name == null)
            return "";

        return name;
    }

    public Integer getVendorScore() {
        if (vendorScore == null)
            return -1;

        return vendorScore;
    }

    public String getLogo() {
        if (logo == null)
            return "";

        return logo;
    }

    public String getEmailAddress() {
        if (emailAddress == null)
            return "";

        return emailAddress;
    }

    public OpeningTime getOpeningTime() {
        return openingTime;
    }

    public String getWebsiteURL() {
        if (websiteURL == null)
            return "";

        return websiteURL;
    }

    public String getColor() {
        if (color == null)
            return "";

        return color;
    }



}
