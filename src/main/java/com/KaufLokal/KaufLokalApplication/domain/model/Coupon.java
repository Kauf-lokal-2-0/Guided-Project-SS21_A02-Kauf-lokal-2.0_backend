package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "KL_COUPON")
@Data
public class Coupon {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "V_ID", updatable = false, nullable = false)
    private UUID id;
}
