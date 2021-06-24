package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Time;

@Data
@Embeddable
public class OpeningTime {
    private String monday;
    private String tuesday;
    private String wednesday;
    private String thursday;
    private String friday;
    private String saturday;
    private String sunday;


    public OpeningTime() {

    }

    public OpeningTime(String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String sunday) {
        this.monday = monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.sunday = sunday;
    }

}
