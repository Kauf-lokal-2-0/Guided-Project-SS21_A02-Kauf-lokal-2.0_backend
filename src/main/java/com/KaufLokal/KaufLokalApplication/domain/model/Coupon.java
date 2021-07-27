package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "COUPON")
@Data
public class Coupon {

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

    @Column(nullable = false)
    private Integer couponCode;

    private Date expiryDate;

    private Double value;

    private Date created;

    public Double getValue() {
        if (value == null) {
            return -1.0;
        }
        return value;
    }

    public Date getExpiryDate() {
        if (expiryDate == null) {
            return new Date();
        }
        return expiryDate;
    }

    public Date getCreated() {
        if (created == null) {
            return new Date();
        }
        return created;
    }
}
