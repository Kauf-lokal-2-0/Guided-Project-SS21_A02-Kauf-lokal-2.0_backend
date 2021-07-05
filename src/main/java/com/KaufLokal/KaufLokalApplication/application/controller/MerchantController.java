package com.KaufLokal.KaufLokalApplication.application.controller;

import com.KaufLokal.KaufLokalApplication.application.dto.*;
import com.KaufLokal.KaufLokalApplication.domain.model.Merchant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.KaufLokal.KaufLokalApplication.application.service.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@Api(value = "Merchant Controller")
public class MerchantController {

    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

    @Autowired
    MerchantService merchantService;

    @Autowired
    RatingService ratingService;

    @Autowired
    MessageService messageService;

    @Autowired
    CouponService couponService;

    @ApiOperation(value = "Get all merchant")
    @GetMapping("/merchant")
    public ResponseEntity<List<MerchantDto>> getAllMerchant() {
        logger.debug("GET: getAllMerchant");
        return new ResponseEntity<>(merchantService.findAll(), HttpStatus.OK);
    }

    @ApiOperation(value = "Get merchant by ID")
    @GetMapping("/merchant/{id}")
    public ResponseEntity<MerchantDto> getMerchantById(@PathVariable UUID id)  {
        logger.debug("GET: getMerchantById");
        return new ResponseEntity<>(merchantService.findById(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Create an new merchant")
    @PostMapping("/merchant")
    public ResponseEntity<MerchantDto> createMerchant(@RequestBody MerchantDto merchantDto) {
        logger.debug("POST: createMerchant");
        return new ResponseEntity<>(merchantService.create(merchantDto), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update an merchant")
    @PutMapping("/merchant")
    public ResponseEntity<MerchantDto> updateMerchant(@RequestBody MerchantDto merchantDto) {
        logger.debug("PUT: updateMerchant");
        return new ResponseEntity<>(merchantService.update(merchantDto), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete an merchant")
    @DeleteMapping("/merchant/{id}")
    public ResponseEntity<Void> deleteMerchant(@PathVariable UUID id) {
        logger.debug("DELETE: deleteMerchant");
        merchantService.delete(id);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "Get all merchant")
    @GetMapping("/merchant/{id}/rating")
    public ResponseEntity<List<RatingDto>> getAllRatingsByMerchantId(@PathVariable UUID id)
    {
        MerchantDto merchant = merchantService.findById(id);
        return new ResponseEntity<>(ratingService.mapToDto(new ArrayList<>(merchant.getRatings())), HttpStatus.OK);
    }

    @ApiOperation(value = "Add coupon to merchant")
    @PostMapping("/merchant/{id}/coupon")
    public ResponseEntity<MerchantDto> addCoupon(@PathVariable UUID id, @RequestBody CouponDto couponDto)
    {
        MerchantDto merchantDto = merchantService.addCoupon(id,couponService.create(couponDto));
        return new ResponseEntity<>(merchantDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Add message to merchant")
    @PostMapping("/merchant/{id}/message")
    public ResponseEntity<MerchantDto> addMessage(@PathVariable UUID id, @RequestBody MessageDto messageDto)
    {
        MerchantDto merchantDto = merchantService.addMessage(id,messageService.create(messageDto));
        return new ResponseEntity<>(merchantDto, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all messages")
    @GetMapping("/merchant/{id}/message")
    public ResponseEntity<List<MessageDto>> getAllMessagesByMerchantId(@PathVariable UUID id)
    {
        MerchantDto merchant = merchantService.findById(id);
        return new ResponseEntity<>(messageService.mapToDto(new ArrayList<>(merchant.getMessages())), HttpStatus.OK);
    }

    @ApiOperation(value = "Get all merchant categories")
    @GetMapping("/merchant/categories")
    public ResponseEntity<List<MerchantCategoryDto>> getAllCategories() {
        logger.debug("GET: getAllMerchantCategories");
        return new ResponseEntity<>(merchantService.getCategories(), HttpStatus.OK);
    }
}
