package com.KaufLokal.KaufLokalApplication.domain.model;

import lombok.*;

import javax.persistence.Embeddable;


@Data
@Embeddable
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class OpeningTime {

    @NonNull
    private String monday;
    @NonNull
    private String tuesday;
    @NonNull
    private String wednesday;
    @NonNull
    private String thursday;
    @NonNull
    private String friday;
    @NonNull
    private String saturday;
    @NonNull
    private String sunday;

    private Boolean isOpen;

}
