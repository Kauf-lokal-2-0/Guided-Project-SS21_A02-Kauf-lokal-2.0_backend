package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.domain.embeddable.Address;
import com.KaufLokal.KaufLokalApplication.domain.model.enums.VendorCategory;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "VENDOR")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Vendor {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, insertable = false)
    private UUID id;

    @Column(nullable = false)
    @NonNull
    private String name;

    @NonNull
    private Integer vendorScore;

    @Column(nullable = false)
    @NonNull
    private Address address;

    @NonNull
    private String logo;

    @Column(nullable = false)
    @NonNull
    private String email;

    @NonNull
    private OpeningTime openingTime;

    @NonNull
    private String websiteURL;

    @NonNull
    private String color;

    @Column(nullable = false)
    @Enumerated
    @NonNull
    private VendorCategory category;

    @ElementCollection
    @NonNull
    private Set<String> detailImages;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @NonNull
    private Set<Coupon> coupons;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @NonNull
    private Set<Rating> ratings;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @NonNull
    private Set<Message> messages;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @NonNull
    private Set<Event> events;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<Poll> polls;

}
