package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "KL_USER")
@Data
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "V_ID", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "V_FIRST_NAME",updatable = true, nullable = true)
    private String firstName;

    @Column(name = "V_SECOND_NAME",updatable = true, nullable = true)
    private String secondName;
}
