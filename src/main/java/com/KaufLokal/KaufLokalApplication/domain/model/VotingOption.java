package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "VotingOptions")
@Data
public class VotingOption {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private int totalAmountVoters;

    @OneToMany
    private Set<User> users;
}
