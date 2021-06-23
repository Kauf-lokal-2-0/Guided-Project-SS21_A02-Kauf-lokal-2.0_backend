package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Date;

@Data
@Embeddable
public class OpeningTime {
    private Date mondey;
    private Date thuesday;
    private Date wednesday;
    private Date thursday;
    private Date friday;
    private Date saturday;
    private Date sunday;
}
