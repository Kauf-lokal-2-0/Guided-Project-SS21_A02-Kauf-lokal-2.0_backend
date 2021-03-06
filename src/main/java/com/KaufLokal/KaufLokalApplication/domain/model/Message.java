package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "MESSAGE")
@Data
public class Message {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    private String title;

    @Column(nullable = false)
    private String message;

    private String imageURL;

    private Date created;

    public String getTitle() {
        if (title == null)
            return "";
        return title;
    }

    public String getImageURL() {
        if (imageURL == null)
            return "";
        return imageURL;
    }

    public Date getCreated() {
        if (created == null)
            return new Date();
        return created;
    }
}
