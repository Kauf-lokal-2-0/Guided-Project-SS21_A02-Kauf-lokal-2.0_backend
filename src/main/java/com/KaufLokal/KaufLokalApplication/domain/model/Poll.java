package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "POLL")
@Data
public class Poll {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false, insertable = false)
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String imageURL;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Set<PollOption> pollOptions;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Vendor vendor;
}
