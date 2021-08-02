package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "USER")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    private Address address;

    @Column(nullable = false)
    private Integer level = 1;

    @OneToMany
    private Set<Vendor> favoriteVendors = new HashSet<>();

    @OneToMany
    private Set<Coupon> favoriteCoupons = new HashSet<>();

    @OneToMany
    private Set<Experience> experiences;

    @OneToMany
    private Set<Rating> ratings;

    public Address getAddress() {
        if (address == null)
            return new Address("","","","","");

        return address;
    }
}
