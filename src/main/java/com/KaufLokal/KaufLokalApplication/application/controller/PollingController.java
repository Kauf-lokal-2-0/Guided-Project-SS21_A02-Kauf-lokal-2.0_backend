package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.PollDto;
import com.KaufLokal.KaufLokalApplication.application.service.PollService;
import com.KaufLokal.KaufLokalApplication.domain.model.Poll;
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
@Api(value = "Voting Controller")
public class PollingController {

    private static final Logger logger = LoggerFactory.getLogger(Poll.class);

    @Autowired
    private PollService pollService;

    @ApiOperation(value = "Get all votings")
    @GetMapping("/poll")
    public ResponseEntity<List<PollDto>> getAllVendor() {
        logger.debug("GET: getAllVotings");
        return new ResponseEntity<>(pollService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Voting by ID")
    @GetMapping("/poll/{id}")
    public ResponseEntity<PollDto> getVendorById(@PathVariable UUID id)  {
        logger.debug("GET: getVotingById");
        return new ResponseEntity<>(pollService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "User votes an option")
    @PostMapping("/poll/{voteId}/vote/{voteOptionId}")
    public ResponseEntity<PollDto> getVendorById(@PathVariable UUID voteId, @PathVariable UUID voteOptionId, @RequestBody UserDto userDto)  {
        logger.debug("GET: UserVotesAnOption");
        return new ResponseEntity<>(pollService.userVotesAnOption(voteId,voteOptionId,userDto), HttpStatus.OK);
    }
}
