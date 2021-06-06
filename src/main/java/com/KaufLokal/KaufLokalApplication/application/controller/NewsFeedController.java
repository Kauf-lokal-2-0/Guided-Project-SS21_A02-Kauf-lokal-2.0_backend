package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.NewsfeedDto;
import com.KaufLokal.KaufLokalApplication.application.dto.ProductDto;
import com.KaufLokal.KaufLokalApplication.application.service.NewsfeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class NewsFeedController {

    @Autowired
    private NewsfeedService newsfeedService;


    @GetMapping("/newsfeed")
    public ResponseEntity<List<NewsfeedDto>> getAllNewsfeed() {
        return new ResponseEntity<>(newsfeedService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/newsfeed/{id}")
    public ResponseEntity<NewsfeedDto> getNewsfeedById(@PathVariable UUID id)  {
        return new ResponseEntity<>(newsfeedService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> createNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        return new ResponseEntity<>(newsfeedService.create(newsfeedDto), HttpStatus.CREATED);
    }

    @PutMapping("/newsfeed")
    public ResponseEntity<NewsfeedDto> updateNewsfeed(@RequestBody NewsfeedDto newsfeedDto) {
        return new ResponseEntity<>(newsfeedService.update(newsfeedDto), HttpStatus.OK);
    }

    @DeleteMapping("/newsfeed/{id}")
    public ResponseEntity<Void> deleteNewfeed(@PathVariable UUID id) {
        newsfeedService.delete(id);
        return ResponseEntity.ok().build();
    }
}
