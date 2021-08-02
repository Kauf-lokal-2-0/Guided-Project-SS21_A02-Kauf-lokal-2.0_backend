package com.KaufLokal.KaufLokalApplication.domain.model;

import io.swagger.models.auth.In;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Experience")
@Data
public class Experience {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    private Vendor vendor;

    @ManyToOne
    private User user;

    private Integer experience;

    private String description;

    private Date created;


}
