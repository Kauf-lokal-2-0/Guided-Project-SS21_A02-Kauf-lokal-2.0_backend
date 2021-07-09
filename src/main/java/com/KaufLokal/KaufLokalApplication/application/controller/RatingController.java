package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.ProductDto;
import com.KaufLokal.KaufLokalApplication.application.dto.RatingDto;
import com.KaufLokal.KaufLokalApplication.application.service.RatingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Rating Controller")
public class RatingController {

    private static final Logger logger = LoggerFactory.getLogger(RatingController.class);

    @Autowired
    private RatingService ratingService;

    @ApiOperation(value = "Get all Ratings")
    @GetMapping("/rating")
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        logger.debug("GET: Rating");
        return new ResponseEntity<>(ratingService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new Rating")
    @PostMapping("/rating")
    public ResponseEntity<RatingDto> createRating(@RequestBody RatingDto ratingDto) {
        logger.debug("POST: Rating");
        return new ResponseEntity<>(ratingService.create(ratingDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "count of all Ratings" )
    @GetMapping("/rating/count")
    public Integer getRatingsCount(){
        return ratingService.getRatingCount();
    }

    @ApiOperation(value = "Arithmetic mean of all ratings" )
    @GetMapping("/rating/arithmetic")
    public Double getArithmeticMeanRating(RatingDto dto){
        return ratingService.getArithmeticMeanRating(dto);
    }
}
