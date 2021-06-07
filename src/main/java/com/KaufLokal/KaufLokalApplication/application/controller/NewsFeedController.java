package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.NewsfeedDto;
import com.KaufLokal.KaufLokalApplication.application.service.NewsfeedService;
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
public class NewsFeedController {

    private static final Logger logger = LoggerFactory.getLogger(NewsFeedController.class);

    @Autowired
    private NewsfeedService newsfeedService;

    @ApiOperation(value = "Find all Newsfeed")
    @GetMapping("/newsfeed")
    public ResponseEntity<List<NewsfeedDto>> getAllNewsfeed() {
        logger.debug("GET: getAllNewsfeed");
        return new ResponseEntity<>(newsfeedService.findAll(), HttpStatus.OK);
    }
    @ApiOperation(value = "Find Newsfeed by ID")
    @GetMapping("/newsfeed/{id}")
    public ResponseEntity<NewsfeedDto> getNewsfeedById(@PathVariable UUID id)  {
        logger.debug("GET: getNewsfeedById");
        return new ResponseEntity<>(newsfeedService.findById(id), HttpStatus.OK);
    }
    @ApiOperation(value = "Create an new Newsfeed")
    @ApiResponses({
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> createNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        logger.debug("POST: createNewsfeed");
        return new ResponseEntity<>(newsfeedService.create(newsfeedDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an Newsfeed")
    @PutMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> updateNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        logger.debug("PUT: Newsfeed");
        return new ResponseEntity<>(newsfeedService.update(newsfeedDto), HttpStatus.OK);
    }
    @ApiOperation(value = "Delet an Newsfeed")
    @DeleteMapping("/newsfeed/{id}")
    public ResponseEntity<Void> deleteNewsfeed(@PathVariable UUID id) {
        logger.debug("DELETE: deleteNewsfeed");
        newsfeedService.delete(id);
        return ResponseEntity.ok().build();
    }
}
