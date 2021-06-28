package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;



@Entity
@Table(name = "Events")
@Data
public class Event {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private EventTypes eventTypes;

    private Date created;
}
