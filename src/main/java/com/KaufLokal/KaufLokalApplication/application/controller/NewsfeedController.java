package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MerchantDto;
import com.KaufLokal.KaufLokalApplication.application.dto.NewsfeedDto;
import com.KaufLokal.KaufLokalApplication.application.service.NewsfeedService;
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
@Api(value = "Newsfeed Controller")
public class NewsfeedController {

    private static final Logger logger = LoggerFactory.getLogger(NewsfeedController.class);

    @Autowired
    NewsfeedService newsfeedService;

    @ApiOperation(value = "Get all newsfeeds")
    @GetMapping("/newsfeed")
    public ResponseEntity<List<NewsfeedDto>> getAllNewsfeeds() {
        logger.debug("GET: getAllNewsfeeds");
        return new ResponseEntity<>(newsfeedService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get newsfeed by ID")
    @GetMapping("/newsfeed/{id}")
    public ResponseEntity<NewsfeedDto> getNewsfeedById(@PathVariable UUID id)  {
        logger.debug("GET: getNewsfeedById");
        return new ResponseEntity<>(newsfeedService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new newsfeed")
    @PostMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> createNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        logger.debug("POST: createNewsfeed");
        return new ResponseEntity<>(newsfeedService.create(newsfeedDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an newsfeed")
    @PutMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> updateNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        logger.debug("PUT: updateNewsfeed");
        return new ResponseEntity<>(newsfeedService.update(newsfeedDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an newsfeed")
    @DeleteMapping("/newsfeed/{id}")
    public ResponseEntity<Void> deleteNewsfeed(@PathVariable UUID id) {
        logger.debug("DELETE: deleteNewsfeed");
        newsfeedService.delete(id);
        return ResponseEntity.ok().build();
    }
}
