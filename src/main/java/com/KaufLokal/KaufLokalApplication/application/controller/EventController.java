package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.EventDto;
import com.KaufLokal.KaufLokalApplication.application.dto.EventTypesDto;
import com.KaufLokal.KaufLokalApplication.application.service.EventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Event Controller")
public class EventController {

    private static final Logger logger = LoggerFactory.getLogger(EventController.class);

    @Autowired
    EventService eventService;

    @ApiOperation(value = "Get all events")
    @GetMapping("/event")
    public ResponseEntity<List<EventDto>> getAllEvents() {
        logger.debug("GET: getAllEvents");
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all event types")
    @GetMapping("/event/types")
    public ResponseEntity<List<EventTypesDto>> getAllEventTypes() {
        logger.debug("GET: getAllEventTypes");

        return new ResponseEntity<>(eventService.getEventTypes(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all vendor events")
    @GetMapping("/event?vendorId={id}")
    public ResponseEntity<List<EventDto>> getAllVendorEvents(@PathVariable UUID id) {
        logger.debug("GET: getAllVendorEvents");
        return new ResponseEntity<>(eventService.findAllEventsByVendor(id), HttpStatus.OK);
    }
}
