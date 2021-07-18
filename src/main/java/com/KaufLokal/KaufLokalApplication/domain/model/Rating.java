package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "RATING")
@Data
public class Rating {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private Double ratingScore;

    public Rating() {
    }

    public Rating(Double ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Double getRatingScore() {
        if(ratingScore == null)
            return 0.0;

        return ratingScore;
    }
}
