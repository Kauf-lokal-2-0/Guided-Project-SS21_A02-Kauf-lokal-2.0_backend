package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.MessageDto;
import com.KaufLokal.KaufLokalApplication.application.dto.UserDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VendorDto;
import com.KaufLokal.KaufLokalApplication.application.dto.VotingDto;
import com.KaufLokal.KaufLokalApplication.application.service.VotingService;
import com.KaufLokal.KaufLokalApplication.domain.model.Voting;
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
public class VotingController {

    private static final Logger logger = LoggerFactory.getLogger(Voting.class);

    @Autowired
    private VotingService votingService;

    @ApiOperation(value = "Get all votings")
    @GetMapping("/voting")
    public ResponseEntity<List<VotingDto>> getAllVendor() {
        logger.debug("GET: getAllVotings");
        return new ResponseEntity<>(votingService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get Voting by ID")
    @GetMapping("/voting/{id}")
    public ResponseEntity<VotingDto> getVendorById(@PathVariable UUID id)  {
        logger.debug("GET: getVotingById");
        return new ResponseEntity<>(votingService.findById(id), HttpStatus.OK);
    }


    @ApiOperation(value = "User votes an option")
    @PostMapping("/voting/vote/{voteOptionId}")
    public ResponseEntity<VotingDto> getVendorById(@PathVariable UUID voteOptionId,@RequestBody UserDto userDto)  {
        logger.debug("GET: UserVotesAnOption");
        return new ResponseEntity<>(votingService.userVotesAnOption(voteOptionId,userDto), HttpStatus.OK);
    }
}
