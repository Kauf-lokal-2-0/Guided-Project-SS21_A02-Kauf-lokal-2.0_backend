package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "NEWSFEED")
@Data
public class Newsfeed {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String offerName;

    @Column(nullable = false)
    private String offerDescription;

    private String offerCreatedDate;

    private String offerLastUpdate;

    private Integer likeAmount;

    private Integer shareAmount;


}
