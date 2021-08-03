package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "POLL_OPTIONS")
@Data
public class PollOption {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, insertable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    private Integer totalAmountVoters;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<User> users;
}
