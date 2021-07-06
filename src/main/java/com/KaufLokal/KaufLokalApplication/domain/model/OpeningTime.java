package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.util.Calendar;
import java.util.Date;

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

    /**
    private boolean isOpen() {

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());

        switch (calendar.get(Calendar.DAY_OF_WEEK)){
            case Calendar.MONDAY:
                break;
            case Calendar.TUESDAY:
                return true;
            case Calendar.WEDNESDAY:
                return true;
            case Calendar.THURSDAY:
                return true;
            case Calendar.FRIDAY:
                return true;
            case Calendar.SATURDAY:
                return true;
            case Calendar.SUNDAY:
                return true;
            default:
                return false;
        }
        return false;

    }
     */

}
