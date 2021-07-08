package com.KaufLokal.KaufLokalApplication.application.dto;

import com.KaufLokal.KaufLokalApplication.domain.model.enums.EventTypes;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class EventDto {
    private UUID id;
    private EventTypes eventTypes;
    private UUID refId;
    private UUID vendorId;
    private Date created;
}
