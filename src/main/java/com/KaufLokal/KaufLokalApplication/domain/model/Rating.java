package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "RATING")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, insertable = false)
    private UUID id;

    @NonNull
    private Double ratingScore;

    public Double getRatingScore() {
        return ratingScore == null ? Double.NEGATIVE_INFINITY : ratingScore;
    }
}
