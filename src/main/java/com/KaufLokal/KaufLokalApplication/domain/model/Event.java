package com.KaufLokal.KaufLokalApplication.domain.model;

import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
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

    @Column(nullable = false)
    private EventTypes eventTypes;

    private UUID refId;

    private UUID vendorId;

    private Date created;

    public Date getCreated() {
        if (created == null)
            return new Date();
        return created;
    }
}
