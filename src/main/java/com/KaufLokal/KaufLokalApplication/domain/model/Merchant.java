package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

/**
 * Händler
 */
@Entity
@Table(name = "KL_MERCHANT")
@Data
public class Merchant {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "V_ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "V_STROE_NAME",updatable = true, nullable = true)
    private String storeName;
}
