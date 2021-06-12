package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.OfferDto;
import com.KaufLokal.KaufLokalApplication.application.service.OfferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Newsfeed Controller")
public class OfferController {

    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

    @Autowired
    private OfferService offerService;

    @ApiOperation(value = "Find all Offer")
    @GetMapping("/offer")
    public ResponseEntity<List<OfferDto>> getAllOffers() {
        logger.debug("GET: getAllOffers");
        return new ResponseEntity<>(offerService.findAll(), HttpStatus.OK);
    }
    @ApiOperation(value = "Find Offer by ID")
    @GetMapping("/offer/{id}")
    public ResponseEntity<OfferDto> getOfferById(@PathVariable UUID id)  {
        logger.debug("GET: getNewsfeedById");
        return new ResponseEntity<>(offerService.findById(id), HttpStatus.OK);
    }
    @ApiOperation(value = "Create an new Offer")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/offer")
    public ResponseEntity<OfferDto> createOffer(@RequestBody OfferDto offerDto) {
        logger.debug("POST: createNewsfeed");
        return new ResponseEntity<>(offerService.create(offerDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an Offer")
    @PutMapping("/offer")
    public ResponseEntity<OfferDto> updateOffer(@RequestBody OfferDto offerDto) {
        logger.debug("PUT: Offer");
        return new ResponseEntity<>(offerService.update(offerDto), HttpStatus.OK);
    }
    @ApiOperation(value = "Delete an Offer")
    @DeleteMapping("/offer/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable UUID id) {
        logger.debug("DELETE: deleteOffer");
        offerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
