package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
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
    @Column(updatable = false, nullable = false, insertable = false)
    private UUID id;

    @Enumerated
    @Column(nullable = false)
    private EventTypes eventTypes;

    private UUID refId;

    private UUID vendorId;

    @CreationTimestamp
    private Date created;

}
